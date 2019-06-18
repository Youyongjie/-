<%@ page contentType="image/jpeg" language="java" import="java.util.*,java.awt.*,java.awt.image.*,javax.imageio.*" pageEncoding="utf-8"%>  
   
<%   
    //设置页面不缓存  
    response.setHeader("Pragma","no-cache");  
    response.setHeader("Cache-Control","no-catch");  
    response.setDateHeader("Expires",0);  
      
    //在内存中创建图象  
    int width = 100;  
    int height = 30;  
    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
      
    //创建图象  
    Graphics g = image.getGraphics();  
    //生成随机对象  
    Random random = new Random();  
    //设置背景色   
    g.fillRect(0,0,width,height);  
    //设置字体  
    g.setFont(new Font("Tines Nev Roman",Font.PLAIN,40));  
    String sRand = "";  
    for(int i = 0; i < 4; i++){  
        String rand = String.valueOf(random.nextInt(10));  
        sRand  += rand;  
        //将认证码显示到图象中  
        g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
        g.drawString(rand,16*i+6,30);  
    }  
    session.setAttribute("rCode",sRand);  
    //图像生效  
    g.dispose();  
    //输出图像到页面  
    ImageIO.write(image,"JPEG",response.getOutputStream());  
    out.clear();  
    out = pageContext.pushBody();
%> 