# oauth2demo
#### 主要参考了这位
详细
https://www.funtl.com/zh/spring-security-oauth2/
git:
https://github.com/topsale/spring-boot-samples/tree/master/spring-security-oauth2

#### 踩了很多坑
1.拿到授权码去操作资源的时候，一直报invalid token。但是试了n遍都不行。后来考虑是不是版本引起的，毕竟版本不同，sql就可能不一样。
##### 然后改版本-》
2.没注意org.springframework.boot parent的版本，子模块怎么修改版本都修改不到自己想要的版本。
##### 然后搞到对应的版本
3.然后就是开始版本冲突，里面有好多mybatis。嗯mybatis可以用mvn树去查是不是重复了，exclude掉，但过程是挺烦的。
##### 再以为是版本冲突mybatis-plus，不能用最新的spring，就改成了很原始的mybatis
4.然后就报Invalid bound statement (not found):，最后发现把mybatis的*.xml放到resources文件夹下就好了，应该也是什么配置的问题。没再找了。
#### 最后终于正常跑起来了，但要研究原理还得看。好费时间啊~
