### 一、linux网络IO 模型有哪些？





### 二、TCP/IP

1. 在浏览器输入https://www.baidu.com按回车以后到浏览器显示的过程中服务器是怎么调用的
```txt
1. 解析域名获取ip: 先本地hosts表中找出是否有域名映射的ip,如果没有则去dns解析域名获取ip（代理服务器的ip）
2. 获取目标IP的mac地址: 用arp协议获取对应ip的mac地址（一般是网关的mac）
3. 建立网络会话连接： 
	1. 客户端获取服务器公钥证书，并验证证书是否有效，并随机生成字符串（秘钥），并通过公钥将数据加密发送给服务器端;
	2. 服务器端收到数据，使用私钥解密成功，通过秘钥发送加密数据;
	3. 客户端收到数据并解密成功，此时https的会话建立成功
4. 客户端使用秘钥加密请求数据，发送到服务期端
5. 服务器端收到数据，使用秘钥解密请求数据;处理请求获取响应数据，在使用秘钥加密返回给客户端
6. 客户端收到数据使用秘钥解密，在浏览器渲染数据；并发起关闭连接的请求（四次挥手关闭会话）
```
2. ISO网络七层模型分为哪些，各有什么功能; TCP/IP的四层模型为哪些; 


3. TCP的三次握手与四次挥手