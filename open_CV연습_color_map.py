from google.colab import drive 
drive.mount('/gdrive')

"""다음의 경로는 변경하지 말것"""

# Commented out IPython magic to ensure Python compatibility.
# %cd /gdrive/MyDrive/ImageProcClass/Notebook-Week07/

import matplotlib.pyplot as plt
import cv2
import numpy as np
import matplotlib.cm as cm

image_path = '../Dongkeun-OpenCV-ImgData/lena.jpg' 

# if img is None:
  #   print("show_with_matplotlib: Could not read the image.")
  #   return
  # if img.shape[2]!=3:
  #   print("\nshow_with_matplotlib: Given image does not contains 3channels.")
  #   return

def show_with_matplotlib(color_img, title, pos):
    """Shows an image using matplotlib capabilities"""

    # Convert BGR image to RGB
    img_RGB = color_img[:, :, ::-1]

    ax = plt.subplot(2, 3, pos)
    plt.imshow(img_RGB)
    plt.title(title)
    plt.axis('on')



def show_with_matplotlib_gray (img, title):
  if img is None:
    print("show_with_matplotlib_gray: Could not read the image.")
    return
  if img.ndim>2:
    print("\nshow_with_matplotlib_gray: Given image has more than 2 dim.")
    return
    
  plt.imshow(img, cmap='gray')
  plt.title(title)
  plt.show()

"""##문제 1:


1. 주어진 영상을 grayscale 로 읽어 들인다 (org_img)
2. 입력 영상과 같은 크기의 빈 컬러 이미지를 만든다 (new_image)
3. 소스코드 color_map_custom_key_colors.py를 참조하여, 자신이 원하는대로 컬러맵을 5개의 값을 이용해 만든다.  
4. 소스코드 color_map_custom_legend.py를 참조하여, Legend를 만든 후 "Legend"라는 타이틀을 부여한 후 출력한다. 
5. 만들어진 컬러맵을 LUT(), applyColorMap()을 이용해 컬러맵을 주어진 영상에 적용해서 두 개의 이미지의 타이틀을 각각 "LUT() Application", "applyColorMap() Application" 로 한 다음 출력한다. 




"""

org_img = cv2.imread(image_path,cv2.IMREAD_GRAYSCALE)
new_image = np.zeros((org_img.shape[0],org_img.shape[1],3),np.uint8)

def make_custom_lut(cmap):
  lut = np.empty(shape=(256,3),dtype =np.uint8)

  max =256
  lastval,lastcol = cmap[0]
  for step, col in cmap[1:]:
    val = int(step*max)
    for i in range(3):
      lut[lastval:val, i]= np.linspace(lastcol[i],col[i],val-lastval)
    
    lastcol = col
    lastval = val

  return lut

#내맘대로 colormap만들기..???

def apply_color_map_lut(g_image, cmap):

  lut = make_custom_lut(cmap)
  h,w = g_image.shape
  out_img = np.empty(shape=(h,w,3),dtype=np.uint8)

  for i in range(3):
    out_img[..., i]=cv2.LUT(g_image, lut[:,i])
  return out_img



def apply_color_map_applyColorMap(g_image, cmap):
  lut = make_custom_lut(cmap)
  lut2 = np.reshape(lut, (256, 1, 3))
  im_color = cv2.applyColorMap(g_image, lut2)
  return im_color

def make_lut_legend(cmap, height):
  lut = make_custom_lut(cmap)
  img = np.repeat(lut[np.newaxis, ...], height, axis =0)

  return img

lut01 = ((0, (58, 182, 9)),
         (0.25, (203, 245, 42)),
         (0.5, (235, 221, 146)),
         (0.75,(10, 165, 210)),
         (1.0, (144, 178, 76)))


lut02 = ((0, (193, 240, 41)),
         (0.25, (113, 56, 204)),
         (0.5, (189, 7, 25)),
         (0.75,(122, 148, 221)),
         (1.0, (54, 137, 182)))


lut03 = ((0, (219, 177, 244)),
         (0.25, (38, 83, 176)),
         (0.5, (92, 135, 50)),
         (0.75,(4, 107, 120)),
         (1.0, (226, 111, 93)))


lut04 = ((0, (150, 206, 212)),
         (0.25, (47, 230, 132)),
         (0.5, (24, 248, 51)),
         (0.75,(133, 12, 180)),
         (1.0, (208, 185, 54)))


lut05 = ((0, (39, 163, 144)),
         (0.25, (63, 217, 34)),
         (0.5, (215, 108, 253)),
         (0.75,(71, 51, 238)),
         (1.0, (7, 63, 241)))


show_with_matplotlib_gray (org_img,"Origin_Image")

custom_lut_01 = apply_color_map_lut(org_img,lut01)
custom_lut_02 = apply_color_map_lut(org_img,lut02)
custom_lut_03 = apply_color_map_lut(org_img,lut03)
custom_lut_04 = apply_color_map_lut(org_img,lut04)
custom_lut_05 = apply_color_map_lut(org_img,lut05)

show_with_matplotlib (custom_lut_01, "LUT() Application_01",1)
show_with_matplotlib (custom_lut_02, "LUT() Application_02",2)
show_with_matplotlib (custom_lut_03, "LUT() Application_03",3)
show_with_matplotlib (custom_lut_04, "LUT() Application_04",4)
show_with_matplotlib (custom_lut_05, "LUT() Application_05",5)

plt.show()

custom_lut_legend_01 = make_lut_legend(lut01,20)
custom_lut_legend_02 = make_lut_legend(lut02,20)
custom_lut_legend_03 = make_lut_legend(lut03,20)
custom_lut_legend_04 = make_lut_legend(lut04,20)
custom_lut_legend_05 = make_lut_legend(lut05,20)

show_with_matplotlib (custom_lut_legend_01, "applyColorMap() Application_01",1)
show_with_matplotlib (custom_lut_legend_02, "applyColorMap() Application_02",2)
show_with_matplotlib (custom_lut_legend_03, "applyColorMap() Application_03",3)
show_with_matplotlib (custom_lut_legend_04, "applyColorMap() Application_04",4)
show_with_matplotlib (custom_lut_legend_05, "applyColorMap() Application_05",5)
