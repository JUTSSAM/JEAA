# 移动端数据通信加密/解密算法

JEAA - Jutssam Encrypt Algorithm version Alpha

AES/CFC/PADDING

加密函数在Encode
解密函数在Decode

对于client和server，可以构建不同的请求和响应格式，代码主要想实现的是加密和解密过程。

## TODO

解密端对json的解析

解密端对sign的验证

## 数据加密

将请求的数据构造成字符串（json格式或者其他通信格式），使用Encode函数可以对数据加密，并计算得到签名数据(sign)。

假设，数据内容为 {"vip":"true"} , 则加密之后的结果如下：

```json

{
  "errcode":0,
  "data":"74BE4E705C1A059BEC92B06E6A47D2E6C5DB796709F500146B34BD4B941A",
  "sign":"c35cf5905b9977d865a022a14e9b74c9",
  "timestamp":1591363269349,
}

```

## 数据解密

对于响应的数据，可先验证其签名是否正常，可以发现数据有没有被篡改。

假设响应内容的数据（data字段）和上述请求数据内容相同，可用解密算法进行解密，结果如下:

```json
{"vip":"true"}
```
