package com.kuky.base.kotlin.demo.test;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.kuky.base.android.kotlin.RetrofitManager;
import com.kuky.base.kotlin.demo.R;
import com.kuky.base.kotlin.demo.test.api.ApiService;
import com.kuky.base.kotlin.demo.test.bean.UserInfo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Jiwenjie
 * email:278630464@qq.com
 * time:2018/12/13
 * desc:测试连接后台部分，查看是否能成功
 * version:1.0
 */
@SuppressWarnings("ALL")
public class TestConnectActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Button btn;

    /** {"code":200,"message":"succeed","user":{"id":2,"username":"admin","phone":"13965972584","isAdmin":0}} **/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        progressDialog = new ProgressDialog(getApplicationContext());
        btn = findViewById(R.id.btn_test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conn();
            }
        });
    }

    /**
     * 连接方法
     */
    @SuppressLint("CheckResult")
    private void conn() {
        /**
         * RxJava + Retrofit
         */
        RetrofitManager.INSTANCE.setBaseUrl(Constans.BASE_URL);
        RetrofitManager.INSTANCE.getMRetrofit().create(ApiService.class)
                .getLoginUser("admin", "123456")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserInfo>() {
                    @Override
                    public void accept(UserInfo userInfo) throws Exception {
                        Toast.makeText(getApplicationContext(), userInfo.getUser().getUsername(), Toast.LENGTH_LONG).show();
                        btn.setText(userInfo.getUser().getUsername() + "登陆成功");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getApplicationContext(), "失败错误", Toast.LENGTH_LONG).show();
                    }
                });

    }

}
