## 后端流程
* uploading image to a static folder in the server
* downloading image from server with the link
* display list of images
  
## Java实现
  资源：https://www.bezkoder.com/spring-boot-image-upload-thymeleaf/
  文件处理类：MultipartFile

Service类实现思路：
* 设置接收文件路径
* 创建文件路径
* 保存文件

图片对象：Image
属性： name、URL。