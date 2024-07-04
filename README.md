task4. Viết 1 số API cơ bản phục vụ các chức năng của người dùng trong 1 hệ thống thông tin.

Các chức năng cụ thể:

1:Thêm user
- Kiểm tra id đã tồn tại hay chưa, nếu chưa thì thực hiện thêm User, nếu rồi thì return
- Thực hiện Validate dữ liệu: name và address không để trống, age phải lớn hơn 1 và nhỏ hơn 100

2:Xóa User
- Kiểm tra User có tồn tại hay không, nếu có thì thực hiện xóa, nếu không thì return.

3:Sửa User
- Kiểm tra User có tồn tại không, nếu có thì thực hiện sửa User, không thì return
- Thực hiện Validate dữ liệu: name và address không để trống, age phải lớn hơn 1 và nhỏ hơn 100

4: tìm kiếm
-findByName, findById, findByName, findByAddress

5:Sắp xếp
-Sắp xếp danh sách User theo tên

Ngoại lệ:
-Bắt ngoại lệ lỗi sql, dữ liệu null

Lưu ý, tương tác tới db dùng jdbc connection , và thực hiện các câu select * from…. thay vì dùng jpa

Thêm: giả sử lúc chạy thì conenction kết nối bt, nhưng trong lúc chạy, ví dụ mất mạng thì lúc này cái connection này của bọn e sẽ ntn ?
cộng vs đọc thêm khái niệm connection pool, thì cái bọn e dùng vs cái pool sẽ có ưu nhược ntn?

[Connection Pool](https://docs.google.com/document/d/1AbVP4E2JQ5Z6lNhl_2K-mwsZ1eV7nkCJGPnOnzbreMg/edit?usp=sharing)
