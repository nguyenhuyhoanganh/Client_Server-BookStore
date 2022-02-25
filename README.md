# Book-Store Restful API

<table>
<thead>
<tr>
<th align="center" colspan="3"><strong>Book</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td align="left"><strong>Request name</strong></td>
<td align="center"><strong>Method</strong></td>
<td align="left"><strong>Link</strong></td>
</tr>
<tr>
<td align="left"><em>Get All Books</em></td>
<td align="center">GET</td>
<td align="left">http://localhost:8080/api/v1/books</td>
</tr>
<tr>
<td align="left"><em>Get Book</em></td>
<td align="center">GET</td>
<td align="left">http://localhost:8080/api/v1/books/{id_book}</td>
</tr>
<tr>
<td align="left"><em>Create Book</em></td>
<td align="center">POST</td>
<td align="left">http://localhost:8080/api/v1/books</td>
</tr>
<tr>
<td align="left"><em>Update Book</em></td>
<td align="center">PATCH</td>
<td align="left">http://localhost:8080/api/v1/books/{id_book}</td>
</tr>
<tr>
<td align="left"><em>Delete Book</em></td>
<td align="center">DELTE</td>
<td align="left">http://localhost:8080/api/v1/books/{id_book}</td>
</tr>
</tbody>
</table>

> Get All Books (with query string)
> > ?page=0&limit=1&sortBy=tenSach,donGia,hinhAnhChinh&search=maNhaXuatBan:1,tenSach:Doraemon,donGia>111000

<table>
<thead>
<tr>
<th align="left">Key</th>
<th align="center" colspan="2">Query</th>
</tr>
</thead>
<tbody>
<tr>
<td align="left" rowspan="3">search</td>
<td align="left">GREATER_THAN_OR_EQUAL</td>
<td align="center">></td>
</tr>
<tr>
<td align="left">LESS_THAN_OR_EQUAL</td>
<td align="center"><</td>
</tr>
<tr>
<td align="left">EQUALS/LIKE</td>
<td align="center">:</td>
</tr>
<tr>
<td align="left">page</td>
<td align="left" colspan="2">default = 0</td>
</tr>
<tr>
<td align="left">limit</td>
<td align="left" colspan="2">default = data.length</td>
</tr>
<tr>
<td align="left">sortBy</td>
<td align="left" colspan="2">default = maSach, can sortcan sort by multiple fields</td>
</tr>
</tbody>
</table>

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
