# From java image, version : 8
#FROM java:8
#指定镜像，这里用网易云仓库的java8镜像
FROM hub.c.163.com/library/java:8-jre
# 作者
MAINTAINER young <youngbing0920@163.com>
# 挂载test-docker目录
VOLUME /tmp

# COPY or ADD to image 复制jar，改名为app.jar
ADD springboot-kafka-0.0.1-SNAPSHOT.jar app.jar

#修改文件的访问时间和修改时间为当前时间
RUN bash -c "touch /app.jar"
ENV LANG C.UTF-8

#时区设置
#RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezonee

#默认8080端口，我的server.port=8181
#指定项目暴露的端口号，与项目配置一样,即容器配置的暴露端口
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]
