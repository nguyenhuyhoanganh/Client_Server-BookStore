# Book-Store Restful API

## Book

| **Request name** | **Method** | **Link**                                     |
| ---------------- | :--------: | -------------------------------------------- |
| _Get All Books_  |    GET     | http://localhost:8080/api/v1/books           |
| _Get Book_       |    GET     | http://localhost:8080/api/v1/books/{id_book} |
| _Creat Book_     |    POST    | http://localhost:8080/api/v1/books           |
| _Update Book_    |   PATCH    | http://localhost:8080/api/v1/books/{id_book} |
| _Delete Book_    |   DELETE   | http://localhost:8080/api/v1/books/{id_book} |

### Get All Books (with query string)

http://localhost:8080/api/v1/books?search=tenSach:Doragon,donGia>15000&page=0&limit=2&sortBy=tenSach,hinhAnhChinh
http://localhost:8080/api/v1/books?page=0&limit=1&sortBy=tenSach,hinhAnhChinh&search=maNhaXuatBan:1,tenSach:Doraemon,donGia>111000F

|  Key   | Query                                                | Character |
| :----: | ---------------------------------------------------- | :-------: | --- |
| search | GREATER_THAN_OR_EQUAL                                |     >     |
|   ^^   | LESS_THAN_OR_EQUAL                                   |     <     |
|   ^^   | EQUALS/LIKE                                          |     :     |
| limit  | default = data.lenght                                |           |
|  page  | default = 0                                          |           |     |
|  sort  | default = maSach,can sortcan sort by multiple fields |           |     |

```
{
    "tenSach": "Và Rồi, Tháng 9 Không Có Cậu Đã Tới",
    "donGia": 113500,
    "dsHinhAnhPhu": "thang9.png , thang9.png",
    "hinhAnhChinh": "thang9.png",
    "moTa": "Tiểu thuyết thanh xuân bí ẩn xoay quanh những suy nghĩ bị giấu kín. Vào mùa hè năm ấy, Keita đã qua đời. Chưa vượt qua khỏi cú sốc đó, Miho, Taiki, Shun, Rino – những người bạn luôn bên cạnh Keita – đã trải qua một mùa hè đầy bất ngờ. Một ngày nọ, Kei – một thiếu niên giống hệt Keita đã mất – xuất hiện trước mặt Miho. “Mình có việc muốn nhờ các cậu. Xin hãy đến nơi mà mình đã chết.” Dù cảm thấy bối rối, nhưng nhóm Miho vẫn bắt đầu cuộc hành trình đi theo dấu chân của Keita.Trong suốt chuyến đi này, những lời nói dối, sự ganh tị, hối hận cùng tình cảm hướng đến Keita dần được hé lộ. Và rồi, kết cục ngoài dự đoán cũng xuất hiện ở phía cuối hành trình.",
    "soLuongMua": 16,
    "soLuongTon": 193,
    "maNhaSanXuat": 1,
    "maTheLoai": 1
}
```
