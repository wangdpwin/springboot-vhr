package com.study.base;

import com.alibaba.fastjson.JSON;
import com.qingstor.sdk.config.EvnContext;
import com.qingstor.sdk.constants.QSConstant;
import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.request.RequestHandler;
import com.qingstor.sdk.request.ResponseCallBack;
import com.qingstor.sdk.service.Bucket;
import com.qingstor.sdk.service.Bucket.DeleteObjectOutput;
import com.qingstor.sdk.service.Bucket.ListObjectsOutput;
import com.qingstor.sdk.service.Bucket.PutObjectOutput;
import com.qingstor.sdk.service.QingStor;
import com.qingstor.sdk.service.QingStor.ListBucketsOutput;
import com.qingstor.sdk.utils.QSSignatureUtil;
import java.io.File;
import java.util.Date;
import org.junit.Test;

public class QingStroTest {

    private String keyId = "QBBVYETDVUZNZYKSNEVZ";
    private String secret = "eIhx10hAgaCQXS6pGhIlgrs0ius0wz6LvZUDQ06w";

    @Test
    public void query(){
        EvnContext evn = new EvnContext(keyId, secret);
        QingStor storService = new QingStor(evn,"pek3");
        try {
            ListBucketsOutput listOutput = storService.listBuckets(null);
            System.out.println(JSON.toJSONString(listOutput));
            Bucket bucket = storService.getBucket("test-bucket", "pek3b");
            Bucket.PutBucketOutput putBucketOutput = bucket.put();

            ListObjectsOutput objects = bucket.listObjects(null);


            File f2 = new File("file/test.txt");
            boolean exists = f2.exists();
            System.out.println("file exists:" + exists);
            if(exists){
                Bucket.PutObjectInput input = new Bucket.PutObjectInput();
                input.setBodyInputFile(f2);
                input.setContentType("text/plain");
                input.setContentLength(f2.length());
                Bucket upload = storService.getBucket("test-upload", "pek3b");
//                Bucket.PutObjectOutput putObjectOutput = upload.putObject("test_object2", input);
                DeleteObjectOutput test_object2 = upload.deleteObject("test_object2");
                System.out.println("file delete:" + JSON.toJSONString(test_object2));
            }

            System.out.println("=== end ===");
        } catch (QSException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void upload(){
        try {
            // 第一步: 创建 EvnContext 并设置 zone 和 bucket
            EvnContext evn = new EvnContext(keyId, secret);
            Bucket bucket = new Bucket(evn, "pek3b", "test-vhr");

            Bucket.PutObjectInput putObjectInput = new Bucket.PutObjectInput();
            File file = new File("file/test.txt");
            putObjectInput.setBodyInputFile(file);
            putObjectInput.setContentLength(file.length());

            // bucket.putObject("对象名称", putObjectInput);

            // 第二步：获取 RequestHandler，正常 bucket.putObject("对象名称", putObjectInput); 就完成操作
            RequestHandler reqHandler = bucket.putObjectAsyncRequest("new", putObjectInput,
                    new ResponseCallBack<PutObjectOutput>() {
                        @Override
                        public void onAPIResponse(PutObjectOutput output) {
                            System.out.println("Message = " + output.getMessage());
                            System.out.println("RequestId = " + output.getRequestId());
                            System.out.println("Code = " + output.getCode());
                            System.out.println("StatueCode = " + output.getStatueCode());
                            System.out.println("Url = " + output.getUrl());
                        }
                    });

            // 第三步：获取 strToSignature。将这个字符串发送到用户的 server 端。
            String strToSignature = reqHandler.getStringToSignature();

            // 第四步：serverAuthorization。server 端处理返回信息，服务端参考如下代码：
             String serverAuthorization = QSSignatureUtil.generateSignature(secret, strToSignature);
//            String serverAuthorization = "您从服务端获取到的签名字符串";

            // 第五步：将计算的签名设置到 request 中

            // 因客户端跟服务端通讯可能有时间差，而签名计算结果跟时间密切相关，因此需要将服务端计算签名时所用的时间设置到 request 中
            // 服务端代码示例：return QSSignatureUtil.formatGmtDate(new Date());
            Date date = new Date();
            //"您从服务端获取的 GMT 时间";
            reqHandler.getBuilder().setHeader(QSConstant.HEADER_PARAM_KEY_DATE, date.toLocaleString());

            reqHandler.setSignature(secret, serverAuthorization);

            // 第六步：发送请求。异步请求使用 sendAsync() 方法。同步请求使用 send() 方法。
            reqHandler.sendAsync();

        } catch (QSException e) {
            e.printStackTrace();
        }
    }

}
