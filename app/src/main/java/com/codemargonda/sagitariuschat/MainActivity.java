package com.codemargonda.sagitariuschat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qiscus.sdk.Qiscus;
import com.qiscus.sdk.data.model.QiscusAccount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b = (Button) findViewById(R.id.button);
        Button a = (Button) findViewById(R.id.bLogin);



        Qiscus.getChatConfig()
                .setStatusBarColor(R.color.blue)
                .setAppBarColor(R.color.red);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qiscus.buildChatWith("davidcornelius@codemargonda.com")
                        .withTitle("Zetra")
                        .build(MainActivity.this, new Qiscus.ChatActivityBuilderListener() {
                            @Override
                            public void onSuccess(Intent intent) {
                                startActivity(intent);
                            }


                            @Override
                            public void onError(Throwable throwable) {
                                throwable.printStackTrace();
                                Toast.makeText(getApplication(), "Gagal", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qiscus.setUser("jefri@codemargonda.com", "12345678")
                            .withUsername("Jefri")
                       // .withAvatarUrl("http://avatar.url.com/handsome.jpg")
                        .save(new Qiscus.SetUserListener() {
                            @Override
                            public void onSuccess(QiscusAccount qiscusAccount) {
                                Toast.makeText(getApplication(), "Berhasil", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                Toast.makeText(getApplication(), "Gagal", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
