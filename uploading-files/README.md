### Uploading Files

[![](https://img.shields.io/static/v1?label=doc&message=Uploading%20Files&color=green)](https://spring.io/guides/gs/uploading-files/)

Learn how to build a Spring application that accepts multi-part file uploads.

* 如果要上传文件到Servlet容器，需要注册一个`MultipartConfigElement`类（相当于`web.xml`中的`<multipart-config>`），不过SpringBoot已经自动配好了（作为SpringMVC自动配置的一部分）；
* 用到了[`MvcUriComponentsBuilder`](src/main/java/com/getset/uploadingfiles/FileUploadController.java#L31)来生成下载文件的链接；
* 限制上传文件的大小：
  * `spring.http.multipart.max-file-size`用于限制总的文件大小；
  * `spring.http.multipart.max-request-size`用于限制一个`multipart/form-data`请求的总大小。

