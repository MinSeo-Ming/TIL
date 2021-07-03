# -*- coding: utf-8 -*-
"""2021-1-ImgProc-HW6-조민서-32174224.ipynb

"""

from google.colab import drive
drive.mount('/gdrive')

# Commented out IPython magic to ensure Python compatibility.
import matplotlib.pyplot as plt
import cv2
import numpy as np
import matplotlib.cm as cm

image_path = '../Dongkeun-OpenCV-ImgData/lena.jpg' 

#이미지 하나 출력하는 함수 (color 버전)
def show_image(img, title):
  img_RGB = img[:, :, ::-1]
  plt.imshow(img_RGB)
  plt.title(title)
  plt.show()

#color 이미지 여러개를 한번에 출력하는 함수
def show_images_linear(img, title, pos):
  img_RGB = img[:, :, ::-1]
  ax = plt.subplot(2, 2, pos)
  plt.imshow(img_RGB)
  plt.title(title)
  plt.axis('on')

#grayscale 이미지 여러개를 한번에 출력하는 함수
def show_gray_images_linear(img, title, pos):
  ax = plt.subplot(3, 3, pos)
  plt.imshow(img,cmap='gray')
  plt.title(title)
  plt.axis('on')
"""##문제 1: 5점


1. 주어진 영상을 읽어 들인다 (org_img)
2. 입력 영상과 같은 크기의 빈 컬러 이미지를 만든다 (new_image)
3. 공백 이미지(new_image) 를 2 x 2 로 분할하여 4개의 서브이미지 영역을 구분한다.
4. 오른쪽 위를 1 영역이라고 하고, 시계 방향으로 2, 3, 4 영역이라고 한다. 
5. 1영역은 blue channel 값만을 가지고, 2영역은 green channel, 3영역은 red channel 값만 가지고, 4 영역은 3개의 channel 이 merging 된 영상을 집어 넣는다.
6. new_image 를 출력한다. 




"""

org_img = cv2.imread(image_path)
height,width,channel = org_img.shape

new_image = np.full((height,width,channel),113,np.uint8)
sub_image1 = org_img[:height//2,width//2:].copy()
sub_image2 = org_img[height//2:,width//2:].copy()
sub_image3 = org_img[height//2:,:width//2].copy()
sub_image4 = org_img[:height//2,:width//2].copy()

sub_image1[:,:,0] =255
sub_image2[:,:,1] =255
sub_image3[:,:,2] =255

new_image [:height//2,width//2:]= sub_image1
new_image [height//2:,width//2:]= sub_image2
new_image [height//2:,:width//2]= sub_image3
new_image [:height//2,:width//2]= sub_image4 

show_image(new_image, "this is new image")

#sub_image1[:, :, 2] = org_image[:height//2,width//2:,0]
"""### 문제 2: 5점
강의자료 2021-1 ImgProc JB-CH05-Updated2103-JH.pdf 에 있는 예제 중, 07.bitwise_op.py 와 08.bitwise_overlap.py 의 예제를 이 노트북에서 실행시키고, 각 라인을 분석해서 자기 노트를 만들기. 
- 예제에 사용하는 이미지가 '../Dongkeun-OpenCV-ImgData' 폴더에 없는 경우, 공유한 소스코드 폴더에서 필요한 이미지를 '../Dongkeun-OpenCV-ImgData' 에 복사해서 사용할 것. 

"""
#300*300 grayscale이미지를 2개 생성하는데 이때 img_2는 img_1을 copy해서 생성
img_1 = np.zeros((300, 300), dtype="uint8")
img_2 = img_1.copy()

# 원을 그리기전 이미지의 높이 넓이를 shape을 통해 구한후 절반을 나눈다
#절반을 나누는 이유는 정사각형 중심에 원을 그리고 싶어서
h,w = img_1.shape[:2]
c_x, c_y = w//2, h//2

#원과 사각형을 그리는 방법중 하나를 사용했다.
#원은 그릴 이미지, 원점 반지름 색 그리고 선의 굵기 인데 -1을 쓴 이유는 원을 색으로 채우기 위해서다.
#사각형은 그릴 이미지 (좌상_x점 좌상 y좌표, 우하 x좌표, 우하 y좌표) 색 굵기 인데 여기서도 한쪽을 하얀색으로 채우기 위해서 -1 사용
cv2.circle(img_1, (c_x, c_y), 100,  255, -1)
cv2.rectangle(img_2, (0,0,c_x, h), 255, -1)

# Bitwise OR
#이미지 1과 이미지 2를 서로 or를 진행 둘중 하나라도 255 면 255로!
bitwise_or = cv2.bitwise_or(img_1, img_2)

# Bitwise AND
#이미지 1과 이미지를 서로 and 연산하는 데 이때 둘다 255여야 255로 표현
bitwise_and = cv2.bitwise_and(img_1, img_2)

# Bitwise XOR
#이미지 1과 이미지 2의 색이 서로 달라야 255로 표현!
bitwise_xor = cv2.bitwise_xor(img_1, img_2)

# Bitwise NOT
#이미지 1의 값을 반전하는 걸로 255 ->0 으로 0->255로 표현한다.
bitwise_not_1 = cv2.bitwise_not(img_1)

# Bitwise NOT
#이미지 2의 값을 반전하는 걸로 255 ->0 으로 0->255로 표현한다.
bitwise_not_2 = cv2.bitwise_not(img_2)

#위에서 회색 이미지 출력하는 함수를 만들어놔서 그걸 이용해서 출력한다.
#보다 깔끔하게 출력하기 위해서 3개 마다 plt.show()를 해서 간격을 만들었다
show_gray_images_linear(img_1, "image 1", 1)
show_gray_images_linear(img_2, "image 2", 2)
show_gray_images_linear(bitwise_or, "image 1 OR image 2", 3)
plt.show()
show_gray_images_linear(bitwise_and, "image 1 AND image 2", 4)
show_gray_images_linear(bitwise_xor, "image 1 XOR image 2", 5)
show_gray_images_linear(bitwise_not_1, "NOT (image 1)", 6)
plt.show()
show_gray_images_linear(bitwise_not_2, "NOT (image 2)", 7)

#맞는 이미지 읽어오기
#opencv white이미지는 로고 부분이 하얀색인 이미지!
image = cv2.imread('../Dongkeun-OpenCV-ImgData/bit_test.jpg')
logo = cv2.imread('../Dongkeun-OpenCV-ImgData/logo _opencv_white.jpg')

#읽어온 이미지로부터 mask빼내는데 요소값이 220 이상이면 255 취급!
#그리고 [1]로 받는 이유는 threshold가 값이 2개라 0번은 true false값
#그리고 masks들은 list로 나와서 분리!
masks = cv2.threshold(logo,220,255,cv2.THRESH_BINARY)[1]
masks_list = cv2.split(masks)

#b,g,r 3개 레이어를 하나로 합쳐서 마스크로 만들려면 bitwise_or로 한 layer씩 진행하면 된다.
#그리고 배경은 앞배경?의 반전으로 진행
temp_fg_mask_pass = cv2.bitwise_or(masks_list[0],masks_list[1])
fg_pass_mask = cv2.bitwise_or(masks_list[2], temp_fg_mask_pass)
bg_pass_mask = cv2.bitwise_not(fg_pass_mask)

#로고를 배경이 되는 이미지 가운데에 위치 시키기 위해서 각각의 height width를 가져온다.
H,W = image.shape[:2]
h,w = logo.shape[:2]

#로고 이미지 위치를 정가운데에 잡기 위해서 
x,y = (W-w)//2,(H-h)//2
#그리고 로고 이미지 크기 만큼 이미지에서 복사해온다
roi = image[y:y+h,x:x+w]

#앞 배경은 로고랑 앞배경 mask와 bitwise_and를 하고
foreground = cv2.bitwise_and(logo,logo,mask=fg_pass_mask)
#이미지서 로고 크기 만큼 빼논 roi에 뒷배경 mask 와 bitwise_and를 하고
background = cv2.bitwise_and(roi,roi,mask=bg_pass_mask)

#뒷 배경과 앞배경은 더해서 로고 크기만큼 로고와 이미지가 합성된 이미지를 만든다.
dst = cv2.add(background,foreground)
#합성된 이미지를 원래 이미지 자리에 배치한다.
image[y:y+h,x:x+w] = dst

# 위에서 만들어놓은 이미지 보여주는 함수 호출
#로고 이미지랑 foreground와 backgroung는 작게 보여줘도 될거 같아서 여러개를 한번에 출력하고  
#위의 것과 구분지어 최종 결과물을 보여주기 위해 중간에 plt.show()를 쓰고 
#최종 결과물은 1개만 보여주는 show_image 함수를 사용
show_images_linear(logo,"this is logo",1)
show_images_linear(foreground,"this is foreground",2)
show_images_linear(background,"this is background",3)
plt.show()
show_image(image,"this is result")
