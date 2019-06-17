package com.example.davidalexfarina.pedidosmobile.modulo_financeiro.gerar_pdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.activity.MainActivity;
import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;
import com.example.davidalexfarina.pedidosmobile.activity.PedidoDaMesaActivity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Locale;

import com.example.davidalexfarina.pedidosmobile.R;

public class PdfCreatorActivity extends AppCompatActivity {
    private static final String TAG = "PdfCreatorActivity";
    private EditText  mContentEditText;
    private Button mCreateButton;
    private File pdfFile;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    private  String numeroMesa;
    private String usuarioApp;
    private String vlrFatura;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_creator);

        mContentEditText = (EditText) findViewById(R.id.edit_text_content);
        mCreateButton = (Button) findViewById(R.id.button_create);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentEditText.getText().toString().isEmpty()){
                    mContentEditText.setError("O corpo está vazio");
                    mContentEditText.requestFocus();
                    return;
                }
                try {
                    createPdfWrapper();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });
        //////////////////////Parametros recebidos da PedidoDaMesaActivity///////////////////////////
        Intent intent = getIntent();//recebe o numero da mesa usar na SQL e carregar apenas os pedidos da mesa selecionada
        Bundle parametros = intent.getExtras();
        numeroMesa = parametros.getString("numeroMesa");
        usuarioApp = parametros.getString("usuarioApp");
        vlrFatura = parametros.getString("vlrFatura");
        Toast.makeText(this, "As informação para gerar PDF\n" +
                "Mesa: "+numeroMesa+"\nUzuário: " + usuarioApp + "\nFatura: "+vlrFatura, Toast.LENGTH_SHORT).show();

        ////////////////////////////////////////////////////

        mContentEditText.setText("Fatura da Mesa: "+numeroMesa +
                "\nAtendente responsavel: "+usuarioApp +
                "\nValor Total: " +vlrFatura+
                "\nDescrição dos pedidos: "+
                "\nPedido: "+"--------"+
                "Valor unitario: "+"--------"+
                "Quantidade: " + "--------"+
                "Valor Total: "+"--------");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.action_menu, menu);*/
        getMenuInflater().inflate(R.menu.context_menu_retornar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_mode_close_button) {
            //Toast.makeText(this, "Fechar essa tela e ir para MesasActivity", Toast.LENGTH_LONG).show();
            Bundle parametros = new Bundle();
            parametros.putString("usuarioApp", usuarioApp);
            parametros.putString("numeroMesa", numeroMesa);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);

            intent.putExtras(parametros);

            startActivity(intent);

            /*
            Intent intent = new Intent(getApplicationContext(), MesasActivity.class);
            startActivity(intent);*/
            return true;
        }
        if (item.getItemId() == R.id.action_mode_exit_button) {
            Bundle parametros = new Bundle();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createPdfWrapper() throws FileNotFoundException,DocumentException{

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    showMessageOKCancel("Você precisa permitir o acesso ao armazenamento",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }else {
            createPdf();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    try {
                        createPdfWrapper();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Permission Denied
                    Toast.makeText(this, "\n WRITE_EXTERNAL Permissão negada", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void createPdf() throws FileNotFoundException, DocumentException {

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/DOCUMENTS");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
            Log.i(TAG, "Criado um novo caminho para o PDF");
        }

        /*pdfFile = new File(docsFolder.getAbsolutePath(),"Pedidos_Mobile_Fatura.pdf");*/
        //pdfFile = new File(docsFolder.getAbsolutePath(),mContentEditText.getText().toString()+".pdf");
        pdfFile = new File(docsFolder.getAbsolutePath(),"Fatura da Mesa: "+numeroMesa+".pdf");
        OutputStream output = new FileOutputStream(pdfFile);
        Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        document.add(new Paragraph(mContentEditText.getText().toString()));

        document.close();
        previewPdf();
        Toast.makeText(this, pdfFile.toString()+"\nSalvo em :"+docsFolder, Toast.LENGTH_LONG).show();

    }

    private void previewPdf() {


        String pdf = mContentEditText.getText().toString();
        File file = Environment.getExternalStoragePublicDirectory("./DOCUMENTS");
        //String  file = "Documents";
       // Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(String.valueOf(file+"/"+pdf+".pdf")), "application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);


        Intent chooser = Intent.createChooser(intent, "Open File !");
        startActivity(chooser);




  /*      PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
       *//* testIntent.setType("Documents/Pedidos_Mobile_Fatura.pdf");*//*
        testIntent.setType("DOCUMENTS/teste.pdf");


        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {


            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(pdfFile);
            intent.setDataAndType(uri, "application/pdf");
            startActivity(intent);
        }else{
            Toast.makeText(this,"Faça o download de um visualizador de PDF como o Adobe por exemplo",Toast.LENGTH_LONG).show();
        }*/

    }
}


