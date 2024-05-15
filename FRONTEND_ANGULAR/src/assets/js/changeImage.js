// = = = = = = = = = = = = = = = = changeImg upload file = = = = = = = = = = = = = = = =
function changeImg(input) {
    //Nếu như tồn thuộc tính file, đồng nghĩa người dùng đã chọn file mới
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        //Sự kiện file đã được load vào website
        reader.onload = function (e) {
            //Thay đổi đường dẫn ảnh
            $(input).siblings('.thumbnail').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
//Khi click #thumbnail thì cũng gọi sự kiện click #image
$(document).ready(function () {
    $('.thumbnail').click(function () {
        $(this).siblings('.image').click();
    });
});



// = = = = = = = = = = = = = = = = changeImg img url = = = = = = = = = = = = = = = =
function renderImage(imageUrlInput) {
    const imageUrl = imageUrlInput.value;
    if (imageUrl) {
      const imageElement = document.createElement('img');
      imageElement.src = imageUrl;
      imageElement.style.width = '120px';
      imageUrlInput.parentNode.appendChild(imageElement);
    }
  }

  document.addEventListener('input', function (event) {
    if (event.target.type === 'text' && event.target.classList.contains('image-url')) {
      renderImage(event.target);
    }
  });

