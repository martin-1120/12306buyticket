# 12306buyticket
12306购票软件
15年写着玩的, 留着也没用,很旧了应该跑不通了, 现开源出来给需要的人学习,
涉及到的东西比较多,算是实验性质的:
调用第三方验证码识别接口识别 12306验证码,
用的是ant工具,ProGuard做代码混淆,exe4j把jar包转exe文可执行文件,jnlp技术 一键从web浏览器下载然后启动执行,jetty提供web环境,java与javascript互操作 ,
看ant的build.xml文件 吧,一键构建exe程序
启动类是com.buyticket.ui.MainFrm


首先就是要抓包分析12306接口,坑点很多,单机的还是比较难抢票,加上12306不但修改接口,各种限制,  需要好的服务器和带宽以及和大量账号,大量代理ip不停切换做分布式抢票系统才行,

另外javaswing写界面真心很难搞
