# -*- coding: utf-8 -*-
"""2021-1-ImgProc-HW6-조민서-32174224.ipynb

"""

from google.colab import drive
drive.mount('/gdrive')

# Commented out IPython magic to ensure Python compatibility.
# %cd /gdrive/MyDrive/ImageProcClass/Notebook-Week06/

import matplotlib.pyplot as plt
import cv2
import numpy as np
import matplotlib.cm as cm

image_path = '../Dongkeun-OpenCV-ImgData/lena.jpg'

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
sub_image1 = new_image[:height//2,width//2:]
sub_image2 = new_image[height//2:,width//2:]
sub_image3 = new_image[height//2:,:width//2]
sub_image4 = new_image[:height//2,:width//2]

sub_image1[:, :, 2] = org_image[:height//2,width//2:,0]

"""### 문제 2: 5점
강의자료 2021-1 ImgProc JB-CH05-Updated2103-JH.pdf 에 있는 예제 중, 07.bitwise_op.py 와 08.bitwise_overlap.py 의 예제를 이 노트북에서 실행시키고, 각 라인을 분석해서 자기 노트를 만들기. 
- 예제에 사용하는 이미지가 '../Dongkeun-OpenCV-ImgData' 폴더에 없는 경우, 공유한 소스코드 폴더에서 필요한 이미지를 '../Dongkeun-OpenCV-ImgData' 에 복사해서 사용할 것. 

"""

