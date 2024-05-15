-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2024 at 10:13 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE `blogs` (
  `blog_id` int(11) NOT NULL,
  `blog_description` varchar(255) DEFAULT NULL,
  `blog_image` varchar(255) DEFAULT NULL,
  `blog_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`blog_id`, `blog_description`, `blog_image`, `blog_title`) VALUES
(1, 'Chắc rằng không ít chàng trai cảm thấy việc chụp hình là vô cùng khó khăn. Đừng lo, Coolmate sẽ hướng dẫn một số cách tạo dáng chụp ảnh nam đẹp và cool ngầu.\nChắc rằng không ít chàng trai cảm thấy việc chụp hình là vô cùng khó khăn. Tâm lý ngại ống kính m', 'https://media.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/November2023/tao-dang-chup-anh-nam-dep.jpg', 'Bí kíp tạo dáng chụp ảnh nam đẹp ngầu như mẫu nam Hàn Quốc'),
(2, 'Tìm hiểu bí kíp phối đồ tập gym nam cực chất để mang lại sự thoải mái và phong cách cho các chàng trai. Xem các gợi ý và nguyên tắc phối đồ tốt nhất để tạo nên một phong cách tập luyện ấn tượng.\nTrang phục tập gym nam là một tiêu chí quan trọng được nhiều', 'https://media.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/May2023/bi-kip-phoi-do-tap-gym-nam-cuc-chat-lai-thoai-mai-cho-chang-1823_747_10.jpg', 'Bí kíp phối đồ tập gym nam cực chất lại thoải mái cho chàng'),
(3, 'Nước Việt Nam ta đã trải qua hơn 4000 năm với hàng ngàn di tích lịch sử nổi tiếng như một chứng tích hào hùng cho tinh thần bất khuất, kiên trung. Hãy cùng Coolmate “điểm danh” top 19+ di tích lịch sử Việt Nam đẹp và nổi tiếng nhất cả nước nhé.\nViệt Nam đ', 'https://media.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/January2022/di-tich-lich-su-viet-nam-11_63.png', 'Tổng hợp 19+ di tích lịch sử Việt Nam đẹp nổi tiếng qua năm tháng'),
(4, 'Nếu bạn muốn tìm kiếm những trang phục \"bao thoải mái\" trong thời tiết nóng bức? Tham khảo ngay top 10 sản phẩm Ex-dry Coolmate trong bài viết nhé!\nMùa hè đến, những sản phẩm hướng đến sự thoải mái ngày càng được quan tâm nhiều hơn. Nếu bạn cũng là một ng', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/top-san-pham-ex-dry-coolmate.jpg', 'Top 10 dòng sản phẩm Ex-Dry bán chạy nhất Coolmate hiện nay'),
(5, 'Bật mí 14 cách giặt quần lót bị dính máu mà không phải ai cũng biết\n1. Giặt quần lót dính máu với nước lạnh\nNước lạnh là \"vũ khí\" đầu tiên và hiệu quả nhất để đánh bay vết máu trên quần lót.  Nước lạnh giúp làm đông cứng máu và ngăn chặn quá trình thấm sâ', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/cach-gap-ao-khoac-gon-gang_(47).jpg', '14 cách giặt quần lót dính máu sạch nhanh chóng ngay tại nhà'),
(6, 'Màu nude là màu gì?\nMàu nude là màu gì? Màu nude là một gam màu trung tính, mang sắc độ dịu nhẹ, gần với màu trắng nhưng có chút ngà. Trong tiếng Anh, \"nude\" được sử dụng để chỉ tình trạng không mặc quần áo. Từ này cũng có thể hiểu là màu sắc gần giống vớ', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/1.png', 'Màu nude là màu gì? Ứng dụng và nguyên tắc phối màu trong cuộc sống'),
(7, '1. Vải hemp là gì? Tìm hiểu về nguồn gốc của vải Hemp\nKhông chỉ “xâm chiếm\" ngành công nghiệp thời trang thế giới, vải hemp còn đang được đón nhận khá mạnh mẽ ở thị trường Việt Nam. Vậy chính xác vải hemp là gì và tại sao loại vải này lại được yêu thích đ', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/vai-hemp-10.jpg', 'Vải hemp là gì? Ưu nhược điểm và ứng dụng trong cuộc sống'),
(8, 'Bật mí 8 cách phối đồ màu đen thời trang, nam tính\nMàu đen tỏa ra sức hút mãnh liệt bởi sự huyền bí, nam tính. Đây cũng chính là tone màu được nam giới ưa chuộng trong thời trang vì tính linh hoạt, sang trọng và lịch lãm. Chính vì vậy, màu đen phối được r', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/13.jpg', 'Màu đen phối với màu gì nam? Top 8 cách phối đồ sành điệu, phong cách'),
(9, 'Vải chống thấm nước là gì?\nCác loại vải chống thấm có khả năng ngăn chặn nước thẩm thấu qua bề mặt. Đồng thời bảo vệ đồ vật bên trong luôn được khô ráo, sạch sẽ và tránh ẩm mốc. Ngày nay chất liệu này sử dụng rất phổ biến để may quần áo, túi xách và những', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/cac-loai-vai-chong-tham-nuoc-3.jpg', '6 loại vải chống thấm nước phổ biến nhất hiện nay'),
(10, 'Vải tole là gì? Cách phân biệt vải tole và vải lanh\nVải tole, hay còn gọi là vải tôn, vải toile,... là chất liệu vải mỏng được tạo nên từ sợi cây lanh pha cùng một số chất liệu khác. Bề mặt vải tole có rất nhiều lỗ thoáng khí nhỏ với kích thước không đều,', 'https://media.coolmate.me/cdn-cgi/image/width=550,height=623,quality=80,format=auto/uploads/April2024/vai-tole-la-gi-9.jpg', 'Vải tole là gì? Phân biệt vải tole và vải lanh bạn nên biết');

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `cart_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `product_product_id` int(11) DEFAULT NULL,
  `user_user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`cart_id`, `quantity`, `total_amount`, `product_product_id`, `user_user_name`) VALUES
(4, 1, 2000000, 118, 'tuanflute'),
(6, 1, 3590000, 35, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `category_status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `category_name`, `category_status`) VALUES
(1, 'ÁO KHOÁC', 1),
(2, 'ÁO THUN', 1),
(3, 'ÁO POLO', 1),
(4, 'ÁO SƠ MI', 1),
(5, 'ÁO CHUI ĐẦU/ HOODIE', 1),
(6, 'QUẦN JOGGER', 1),
(7, 'QUẦN SHORTS', 1),
(8, 'QUẦN DÀI NỮ', 1),
(9, 'VÁY', 1),
(10, 'GIÀY DÉP', 1),
(11, 'TÚI VÍ', 1),
(12, 'MŨ NÓN', 1);

-- --------------------------------------------------------

--
-- Table structure for table `coupons`
--

CREATE TABLE `coupons` (
  `id` int(11) NOT NULL,
  `active` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `percent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coupons`
--

INSERT INTO `coupons` (`id`, `active`, `code`, `description`, `percent`) VALUES
(1, 1, 'DISCOUNT3', 'Tối thiểu 100K', 3),
(2, 1, 'DISCOUNT4', 'Tối thiểu 200K', 4),
(3, 1, 'DISCOUNT8', 'Tối thiểu 500K', 8),
(4, 1, 'DISCOUNT10', 'Tối thiểu 1000K', 10),
(5, 1, 'DISCOUNT15', 'Tối thiểu 2000K', 15),
(6, 1, 'DISCOUNT20', 'Tối thiểu 3000K', 20),
(7, 1, 'DISCOUNT25', 'Tối thiểu 4000K\n', 25),
(8, 1, 'DISCOUNT30', 'Tối thiểu 5000K\n', 30),
(9, 1, 'SALE3004', 'Tối thiểu 3000K\n', 30),
(10, 1, 'SALE275', 'Tối thiểu 2750K', 20),
(11, 1, 'FREESHIP', 'Tối thiểu 0K', 10),
(12, 1, 'TUANFLUTE', 'Tối thiểu 1000K', 27);

-- --------------------------------------------------------

--
-- Table structure for table `coupon_conditions`
--

CREATE TABLE `coupon_conditions` (
  `id` int(11) NOT NULL,
  `attribute` varchar(255) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  `discount_amount` double NOT NULL,
  `operator` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coupon_conditions`
--

INSERT INTO `coupon_conditions` (`id`, `attribute`, `coupon_id`, `discount_amount`, `operator`, `value`) VALUES
(1, 'minimum_amount', 12, 27, '>', '1000000'),
(2, 'minimum_amount', 11, 10, '>', '0'),
(3, 'minimum_amount', 10, 20, '>', '2750000'),
(4, 'minimum_amount', 9, 30, '>', '3000000'),
(5, 'minimum_amount', 8, 30, '>', '5000000'),
(6, 'minimum_amount', 7, 25, '>', '4000000'),
(7, 'minimum_amount', 6, 20, '>', '3000000'),
(8, 'minimum_amount', 5, 15, '>', '2000000'),
(9, 'minimum_amount', 4, 10, '>', '1000000'),
(10, 'minimum_amount', 3, 8, '>', '500000'),
(11, 'minimum_amount', 2, 4, '>', '200000'),
(12, 'minimum_amount', 1, 3, '>', '100000');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_address` varchar(255) DEFAULT NULL,
  `order_amount` double DEFAULT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `order_email` varchar(255) DEFAULT NULL,
  `order_full_name` varchar(255) DEFAULT NULL,
  `order_note` varchar(255) DEFAULT NULL,
  `order_payment_methods` varchar(255) DEFAULT NULL,
  `order_phone_name` varchar(255) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `order_status_payment` varchar(255) DEFAULT NULL,
  `coupon_id` int(11) DEFAULT NULL,
  `user_user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_address`, `order_amount`, `order_date`, `order_email`, `order_full_name`, `order_note`, `order_payment_methods`, `order_phone_name`, `order_status`, `order_status_payment`, `coupon_id`, `user_user_name`) VALUES
(1, 'Hà Nội', 1057000, '2024-5-15 15:7:31', 'tuanflute27052004@gmail.com', 'tuanflute', 'thank you', 'Thanh toán khi giao hàng', '0386564543', 5, 'Đã thanh toán', NULL, 'tuanflute'),
(2, 'Hà Nội', 2380000, '2024-5-15 15:7:31', 'nguyenvana@gmail.com', 'nguyễn văn a', ':))', 'Thanh toán khi giao hàng', '123456789', 1, 'Chưa thanh toán', NULL, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `order_detail_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_money` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_detail`
--

INSERT INTO `order_detail` (`order_detail_id`, `order_id`, `price`, `product_id`, `quantity`, `total_money`) VALUES
(1, 1, 990000, 114, 1, 990000),
(2, 1, 2290000, 55, 1, 2290000),
(3, 1, 7290000, 4, 1, 7290000),
(4, 2, 1190000, 115, 2, 2380000);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_category_id` int(11) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_sale_price` double DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_category_id`, `product_description`, `product_image`, `product_name`, `product_price`, `product_sale_price`, `product_status`) VALUES
(1, 1, 'VACATION GETAWAYS\nTặng ngay MONOGRAM MEGA BEAR MUG cho mọi hoá đơn mua hàng nguyên giá từ 4.990.000đ\nThời gian áp dụng: 27.04 - 01.05.2024\nƯu đãi không áp dụng cùng với các CTKM khác', 'https://product.hstatic.net/200000642007/product/50bks_3ajpv0234_1_420ed0c03a4640aeb844117412639ef3_6eb0e4b77f2e4781b89633abc2559534_master.jpg', 'Áo khoác bóng chày unisex Wool Wappen Play Wool', 9890000, 0, 1),
(2, 1, 'Thể hiện tinh thần thể thao đầy phong cách cùng áo khoác bóng chày Nylon. Sở hữu chất liệu nylon cao cấp, mềm mại chống thấm nước cùng lớp lót in logo ấn tượng, item này với phom dáng trẻ trung cùng đường kẻ màu nổi bật tương phản sẽ giúp bạn dễ dàng khẳn', 'https://product.hstatic.net/200000642007/product/07gnd_3ajpv0834_1_6f855ec75fd145ee817d5b089fbbb089_b0e13257370a44cfb97d23ddd2e3c0fa_master.jpg', 'Áo khoác bóng chày unisex tay dài Nylon', 7990000, 6990000, 1),
(3, 1, 'Bứt phá cá tính với chiếc gilet Wool Collar Varsity. Với sự kết hợp màu sắc đầy tương phản trên phom dáng áo thể thao đậm chất MLB, Wool Collar Varsity hứa hẹn sẽ là nét chấm phá thời thượng cho phong cách của bạn.', 'https://product.hstatic.net/200000642007/product/50crd_3akpv0341_6_0be0910f12db4e55b7cc3d477b236466_657bec13e25643248a644260ff2bb690_master.jpg', 'Áo khoác gilet unisex sát nách cổ V Wool Collar Varsity', 3490000, 2990000, 1),
(4, 1, 'Nâng tầm thời trang đường phố với chiếc áo khoác denim Classic Monogram Embossed đầy cá tính. Không chỉ đem đến sự thoải mái mà cùng tính ứng dụng cao của chất liệu denim bất bại, Classic Monogram Embossed còn đề cao tinh thần phóng khoáng, năng động giúp', 'https://product.hstatic.net/200000642007/product/50ins_3adkm0341_2_05ffba1a9feb46859bdae81013842535_c04b520bea314beabe863cc6ba99e712_master.jpg', 'Áo khoác denim cổ bẻ tay dài Classic Monogram Embossed', 7290000, 0, 1),
(5, 1, 'Mang đến sự kết hợp hoàn hảo giữa phong cách cổ điển và hiện đại, áo khoác cardigan Varsity Big Logo từ MLB là một lựa chọn thời trang không thể bỏ qua. Nổi bật với họa tiết logo ấn tượng mang đến sự trẻ trung, năng động, Varsity Big Logo hứa hẹn sẽ cùng ', 'https://product.hstatic.net/200000642007/product/50crd_3akcv0141_1_954b2d51e9e24ae39df65473ec3ce177_f8e516f9f90746d493fe48ee8696c7c7_master.jpg', 'Áo khoác cardigan unisex cổ V tay dài Varsity Big Logo', 4890000, 4590000, 1),
(6, 1, 'Gây ấn tượng với gam màu thời thượng mang hiệu ứng tương phản từ chi tiết sọc nổi bật, áo khoác bóng chày Classic Monogram Jagard Varsity hứa hẹn sẽ giúp các MLB Crew nắm trọn bí quyết trendy và nổi bật mỗi khi xuống phố. Chỉ cần mix-match đơn giản cùng q', 'https://product.hstatic.net/200000642007/product/50sad_3ajpm0441_1_093c173a557b40c792bf9ee62cd3681c_6bffc2e9501c457e89ab2a68781bfb22_master.jpg', 'Áo khoác bóng chày unisex Classic Monogram Jagard Varsity', 8490000, 8000000, 1),
(7, 1, 'Được chăm chút tỉ mỉ từ chất liệu đến những chi tiết nhỏ như cách phối họa tiết monogram thời thượng, chiếc áo khoác cardigan Dia Monogram sẽ làm trang phục hàng ngày của bạn thêm phong cách, nổi bật, giúp bạn tự tin hơn dù ở bất cứ đâu.', 'https://product.hstatic.net/200000642007/product/07rbs_3akcm0134_1_77755f5d05eb4b528b777ce4b4464783_ef02b636ae924b27b3a1d72a421f0841_master.jpg', 'Áo khoác cardigan unisex cổ V tay dài Dia Monogram', 6490000, 5999999, 1),
(8, 1, 'Sự cộng hưởng từ thiết kế cổ chữ V, màu sắc cho tới logo bóng chày thêu nổi bật ở ngực trái và mặt sau áo, khiến chiếc áo khoác cardigan Varsity này trở thành một item không thể thiếu trong tủ đồ của bất kì ai.', 'https://product.hstatic.net/200000642007/product/50bks_3akcv0234_1_6eb1988628d94cb2b9e180f9bb3e8faf_7fec74b55f12492389a344ccc9533991_master.jpg', ' Áo khoác cardigan unisex cổ V Varsity', 6490000, 0, 1),
(9, 1, 'Với họa tiết Monogram sang trọng cùng thiết kế dáng áo đầy ấn tượng, chiếc áo khoác lông Classic Monogram Suede Mustang hứa hẹn sẽ giúp nâng tầm mọi outfit của bạn một cách dễ dàng. Còn chần chừ gì nữa mà không thể hiện phong cách mùa đông đầy thời thượng', 'https://product.hstatic.net/200000642007/product/50bks_3ajpm0334_2_32a8895e5a9f41678803e5917eff5e05_3de395c7b1c843988d54f6171a540752_master.jpg', 'Áo khoác lông unisex cổ bẻ tay dài Classic Monogram Suede Mustang', 12490000, 12000000, 1),
(10, 1, 'Sự cộng hưởng từ thiết kế cổ chữ V, màu sắc cho tới logo bóng chày thêu nổi bật ở ngực trái và mặt sau áo, khiến chiếc áo khoác cardigan Varsity này trở thành một item không thể thiếu trong tủ đồ của bất kì ai.', 'https://product.hstatic.net/200000642007/product/50pkl_3akcv0234_1_79d2864884a247a996591b9886411482_def5d084660e4db0810b5e9343c600e5_master.jpg', 'Áo khoác cardigan unisex cổ V Varsity', 6990000, 6299000, 1),
(11, 2, 'Mang đến vẻ ngoài trẻ trung và năng động, áo thun Heart Small Logo sẽ là must-have item cho tủ đồ của mọi tín đồ thời trang. Sở hữu chất liệu cotton mềm mại, thoáng mát, nổi bật với hoạ tiết logo đặc trưng quen thuộc được cách điệu khéo léo in nổi bật ở t', 'https://product.hstatic.net/200000642007/product/50ivs_3atsh0143_1_3644bea8c45f4a319351eda67076ef1d_bbf0e7ce44ac454888911f9ab8b75a66_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Heart Small Logo', 1390000, 1190000, 1),
(12, 2, 'Mang đến vẻ ngoài trẻ trung và năng động, áo thun Heart Small Logo sẽ là must-have item cho tủ đồ của mọi tín đồ thời trang. Sở hữu chất liệu cotton mềm mại, thoáng mát, nổi bật với hoạ tiết logo đặc trưng quen thuộc được cách điệu khéo léo in nổi bật ở t', 'https://product.hstatic.net/200000642007/product/50bks_3atsh0143_1_a54cde177f1f46549905d6eb1323f475_804c0a922db84cc4b71e412c4e5c841a_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Heart Small Logo', 1290000, 0, 1),
(13, 2, 'Mang đến vẻ ngoài trẻ trung và năng động, áo thun Heart Small Logo sẽ là must-have item cho tủ đồ của mọi tín đồ thời trang. Sở hữu chất liệu cotton mềm mại, thoáng mát, nổi bật với hoạ tiết logo đặc trưng quen thuộc được cách điệu khéo léo in nổi bật ở t', 'https://product.hstatic.net/200000642007/product/43bgl_3atsh0143_1_6efaefb1c8b1490ea0edc5ca6bbfaf12_d788d10c2cc740cfa35b881121379449_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Heart Small Logo', 1390000, 1190000, 1),
(14, 2, 'Họa tiết in cùng phông chữ được cách điệu đáng yêu, trẻ trung là điểm nhấn nổi bật cho chiếc áo thun Varsity New York Yankees, sẵn sàng trở thành trợ thủ đắc lực cho các MLB-crew dẫn đầu xu hướng. Chính vì thế, không cần tô điểm cầu kỳ, chỉ cần mix-match ', 'https://product.hstatic.net/200000642007/product/50pkm_3arsv0143_1_9695b7fe4fed46e99f69f5f7d79900fa_ded14c2c4f0a4ed59558bd6e97f1c7f7_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Varsity New York Yankees', 1790000, 1590000, 1),
(15, 2, 'Họa tiết in cùng phông chữ được cách điệu đáng yêu, trẻ trung là điểm nhấn nổi bật cho chiếc áo thun Varsity New York Yankees, sẵn sàng trở thành trợ thủ đắc lực cho các MLB-crew dẫn đầu xu hướng. Chính vì thế, không cần tô điểm cầu kỳ, chỉ cần mix-match ', 'https://product.hstatic.net/200000642007/product/50mgl_3arsv0143_1_338c4ff5b8834f928209df014bb93033_5c8e66cfd034494c99327d6e59460cc3_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Varsity New York Yankees', 1990000, 1690000, 1),
(16, 2, 'Áo thun New Year Dragon Overfit với thiết kế đậm chất nghệ thuật là một tuyên ngôn thời trang đầy mạnh mẽ. Được sáng tạo với hình ảnh chú rồng - biểu tượng của năm 2024 kết hợp hài hòa cùng logo thương hiệu tạo nên điểm nhấn độc đáo trên nền gam màu tối g', 'https://product.hstatic.net/200000642007/product/43nys_3atsq0141_1_ac3a76475c894e00bdb2935ef9379bea_4f63093ef8624bb1973c5a71736ad9e2_master.jpg', 'Áo thun unisex cổ tròn tay ngắn New Year Dragon Overfit', 1690000, 1390000, 1),
(17, 2, 'Áo thun New Year Dragon Overfit với thiết kế đậm chất nghệ thuật là một tuyên ngôn thời trang đầy mạnh mẽ. Được sáng tạo với hình ảnh chú rồng - biểu tượng của năm 2024 kết hợp hài hòa cùng logo thương hiệu tạo nên điểm nhấn độc đáo trên nền gam màu tối g', 'https://product.hstatic.net/200000642007/product/50crs_3atsq0141_1_b13da46ff7b74c459bc13b22565bb71c_5a0c7b184d934ec0b16907fa4d11d5f5_master.jpg', 'Áo thun unisex cổ tròn tay ngắn New Year Dragon Overfit', 1690000, 1290000, 1),
(18, 2, 'Hãy cùng MLB F5 tủ đồ năng động của bạn với chiếc áo thun Varsity Number Overfit! Có thiết kế phom dáng cơ bản trên nền chất liệu vải mềm mại kết hợp cùng các gam màu nổi bật và họa tiết in đầy năng động, đây hứa hẹn sẽ là it', 'https://product.hstatic.net/200000642007/product/07bll_3atsv0334_1_e6f6651667824c679b026944f2c3bf7c_7a57b5081a8b41149a8de48082801393_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Varsity Number Overfit', 1390000, 1190000, 1),
(19, 2, 'Mang tinh thần năng động đậm chất MLB với chiếc áo thun Varsity Cursive Graphic Overfit. Có thiết kế basic kết hợp cùng họa tiết in ấn tượng ở trước áo, item này không chỉ đem lại cho bạn cảm giác thoải mái từ chất liệu vải m', 'https://product.hstatic.net/200000642007/product/10pks_3atsv0434_1_446302a5b7144a1e8cffe4e65b04370c_5eee1f55d4124a71827b37cb93f81680_master.jpg', 'Áo thun unisex cổ tròn tay ngắn Varsity Cursive Graphic Overfit', 1390000, 0, 1),
(20, 2, 'Với hình ảnh thể thao là nét biểu tượng của thương hiệu, MLB đã tạo nên sự biến tấu sinh động hơn bằng cách thêm vào hình ảnh một chú gấu cầm gậy đánh golf và vợt tennis để thể hiện tinh thần luôn sẵn sàng đối mặt với những \"quả bó', 'https://product.hstatic.net/200000642007/product/50bks_3atse0334_1_7477d62e24054123958d170e1e919931_d7dabff799aa449393fb5d2ef48b05d8_master.jpg', 'Áo thun unisex cổ tròn tay ngắn in hình dễ thương', 1590000, 0, 1),
(21, 3, 'Chiếc áo polo Varsity Over New York Yankees được thiết kế để giúp mọi MLB-crew tự tin khẳng định cá tính của mình. Với chất liệu vải mềm mại phối cùng họa tiết thêu tinh tế trên ngực mang điểm nhấn lý tưởng cho tổng thể, chiếc áo giúp bạn dễ dàng tạo nên ', 'https://product.hstatic.net/200000642007/product/50ivs_3apqv0243_1_1ace1902b0b84a90858370b63053f237_cf9223acbb104e6bb9b5492715e0b126_master.jpg', 'Áo polo unisex cổ bẻ tay ngắn Varsity Over New York Yankees', 2490000, 2290000, 1),
(22, 3, 'Chiếc áo polo Varsity Over New York Yankees được thiết kế để giúp mọi MLB-crew tự tin khẳng định cá tính của mình. Với chất liệu vải mềm mại phối cùng họa tiết thêu tinh tế trên ngực mang điểm nhấn lý tưởng cho tổng thể, chiếc áo giúp bạn dễ dàng tạo nên ', 'https://product.hstatic.net/200000642007/product/50bks_3apqv0243_1_16cc8c08f0f84f1fa91e45dfc0871cb9_d9c1cc809d6e45d298208fdc46f6f3b8_master.jpg', 'Áo polo unisex cổ bẻ tay ngắn Varsity Over New York Yankees', 2390000, 0, 1),
(23, 3, 'Áo polo Varsity Shoulder Color Overfit Kara mang đến sự kết hợp hoàn hảo giữa phong cách cổ điển và cá tính hiện đại. Với thiết kế hài hòa từ chất liệu vải mềm mại phối cùng chi tiết logo thêu tinh tế, tất cả đã tạo nên một tổng thể đầy thanh lịch, sẵn sà', 'https://product.hstatic.net/200000642007/product/50nys_3apqv0143_1_5d0215e11c854cb0bf030c37528efb40_master.jpg', 'Áo polo unisex cổ bẻ tay ngắn Varsity Shoulder Color Overfit Kara', 2490000, 2000000, 1),
(24, 3, 'Áo polo Varsity Shoulder Color Overfit Kara mang đến sự kết hợp hoàn hảo giữa phong cách cổ điển và cá tính hiện đại. Với thiết kế hài hòa từ chất liệu vải mềm mại phối cùng chi tiết logo thêu tinh tế, tất cả đã tạo nên một tổng thể đầy thanh lịch, sẵn sà', 'https://product.hstatic.net/200000642007/product/50ivs_3apqv0143_1_98cffc5826be4222bee433359ae4e38b_master.jpg', 'Áo polo unisex cổ bẻ tay ngắn Varsity Shoulder Color Overfit Kara', 2590000, 0, 1),
(25, 3, 'Áo polo Varsity Shoulder Color Overfit Kara mang đến sự kết hợp hoàn hảo giữa phong cách cổ điển và cá tính hiện đại. Với thiết kế hài hòa từ chất liệu vải mềm mại phối cùng chi tiết logo thêu tinh tế, tất cả đã tạo nên một tổng thể đầy thanh lịch, sẵn sà', 'https://product.hstatic.net/200000642007/product/45pks_3apqv0143_1_88ac3b32b0424b5bbbdbbd65e7d96835_master.jpg', 'Áo polo unisex cổ bẻ tay ngắn Varsity Shoulder Color Overfit Kara', 2490000, 2190000, 1),
(26, 3, '', 'https://product.hstatic.net/200000642007/product/07bls_3akpm0533_1_86e32d18a108446f83af49a613ddf406_76b0962a0e624c858da39d3f5c2e0252_master.jpg', 'Áo polo unisex tay ngắn Cube Monogram All Over', 4490000, 4190000, 1),
(27, 3, '', 'https://product.hstatic.net/200000642007/product/07crs_3lpqm0333_1_d6cd4d13de604e9fb4f274eadfd7a866_3c0a82977493493f9ee71ad8edc7ab52_master.jpg', 'Áo polo nam tay ngắn Partial Monogram Collar', 2890000, 0, 1),
(28, 3, '', 'https://product.hstatic.net/200000642007/product/50bks_3lpqb0133_1_d243d24b95bc4f2c91018ed5f4bbdef0_dab59ee1ce214162ba0ec4cf04bac9e0_master.jpg', 'Áo polo nam tay ngắn Basic Comfortable Fit Collar', 1990000, 1690000, 1),
(29, 3, '', 'https://product.hstatic.net/200000642007/product/07crs_3lpqm0133_1_22a1fe94f80142e38b54760f6532b04d_db368ba4f5d84dd7ac38c4f3cb14a8f4_master.jpg', 'Áo polo nam tay ngắn Classic Monogram', 3590000, 3000000, 1),
(30, 3, '', 'https://product.hstatic.net/200000642007/product/50mgs_3lpqb0133_1_1efd6d1fafd048f99417865728cf002e_cd6739ebf5f7480a864016c94012e2fe_master.jpg', 'Áo polo nam tay ngắn Basic Comfortable Fit Collar', 1990000, 0, 1),
(31, 4, 'Trải nghiệm sự sang trọng và đẳng cấp cùng chiếc áo sơ mi Monogram Jacquard. Được hoàn thiện từ chất liệu cotton cao cấp mang lại sự thoải mái tuyệt đối với phom dáng rộng rãi, mỗi đường may được thực hiện một cách tỉ mỉ và tinh tế không chỉ phản ánh đẳng', 'https://product.hstatic.net/200000642007/product/50crs_3awsm0441_1_d1e99bcae05c413d8eea8b7f63df647d_0a2a4dadccd341de96f08a2fe83695c9_master.jpg', 'Áo sơ mi unisex cổ bẻ tay dài Monogram Jacquard', 5590000, 0, 1),
(32, 4, 'Trải nghiệm sự sang trọng và đẳng cấp cùng chiếc áo sơ mi Monogram Jacquard. Được hoàn thiện từ chất liệu cotton cao cấp mang lại sự thoải mái tuyệt đối với phom dáng rộng rãi, mỗi đường may được thực hiện một cách tỉ mỉ và tinh tế không chỉ phản ánh đẳng', 'https://product.hstatic.net/200000642007/product/43cal_3awsm0441_1_48c5335c560e49ca8b569da33f197497_181bf2cea6ed46d89533fe96d2c645e7_master.jpg', 'Áo sơ mi unisex cổ bẻ tay dài Monogram Jacquard', 5590000, 5190000, 1),
(33, 4, 'Bắt nhịp phong cách sống năng động và hiện đại cùng áo sơ mi Basic Multi Mega Logo Prints. Với chất liệu denim trẻ trung kết hợp cùng họa tiết logo MLB monogram nổi bật, chiếc áo không chỉ góp phần tạo nên điểm nhấn ấn tượng cho mọi outfit mà còn giúp bạn', 'https://product.hstatic.net/200000642007/product/50ins_3adrb0243_1_75525022eec34c9da0b74492161c2f7e_36f02eeec0f243708abc1339b215c78a_master.jpg', 'Áo sơ mi denim unisex tay ngắn Basic Multi Mega Logo Prints', 3890000, 0, 1),
(34, 4, 'Bắt nhịp phong cách sống năng động và hiện đại cùng áo sơ mi Basic Multi Mega Logo Prints. Với chất liệu denim trẻ trung kết hợp cùng họa tiết logo MLB monogram nổi bật, chiếc áo không chỉ góp phần tạo nên điểm nhấn ấn tượng cho mọi outfit mà còn giúp bạn', 'https://product.hstatic.net/200000642007/product/07crs_3adrb0243_1_2493ec4fcc00483882c6d2319fad8e4d_ccd0c42bf52649c9b603415d163bbcf0_master.jpg', 'Áo sơ mi denim unisex tay ngắn Basic Multi Mega Logo Prints', 3890000, 3590000, 1),
(35, 4, 'Bạn là người yêu thích sự đơn giản nhưng không kém phần nổi bật? Vậy thì chiếc áo sơ mi Varsity chính là lựa chọn hoàn hảo dành cho bạn. Nổi bật với phom dáng rộng rãi, tối giản cùng thiết kế đơn sắc có họa tiết thương hiệu đặc trưng, đây là item sáng giá', 'https://product.hstatic.net/200000642007/product/50whs_3awsv0141_2_0d588d5e51d04018b7916122b64d5a5e_812002b473464265b986b4baabc99879_master.jpg', 'Áo sơ mi unisex cổ bẻ tay dài Varsity', 3590000, 0, 1),
(36, 4, 'Áo sơ mi Classic Monogram Jacquard mang đến sự kết hợp hoàn hảo giữa phong cách đường phố và sự thoải mái, là một lựa chọn không thể thiếu trong tủ đồ của bạn. Với họa tiết monogram NY đặc trưng trên nền chất liệu denim cao cấp, kết hợp cùng kiểu dáng đơn', 'https://product.hstatic.net/200000642007/product/50bll_3adrm0141_1_24a821ad388444138700913b5ac50bbe_49be51f8463345568904e5dcc95e9a36_master.jpg', 'Áo sơ mi denim unisex Classic Monogram Jacquard', 5690000, 5290000, 1),
(37, 4, 'Bạn là người yêu thích sự đơn giản nhưng không kém phần nổi bật? Vậy thì chiếc áo sơ mi Varsity chính là lựa chọn hoàn hảo dành cho bạn. Nổi bật với phom dáng rộng rãi, tối giản cùng thiết kế đơn sắc có họa tiết thương hiệu đặc trưng, đây là item sáng giá', 'https://product.hstatic.net/200000642007/product/43nys_3awsv0141_1_903bddf4e6d84a78a66a75ff5ba2036b_82dafb2808304eeea04d9736508807da_master.jpg', 'Áo sơ mi unisex cổ bẻ tay dài Varsity', 3590000, 0, 1),
(38, 4, 'Chiếc áo sơ mi denim với phong cách thời thượng, năng động, được làm từ chất liệu thoáng mát kết hợp với kiểu dáng rộng rãi trên nền gam màu hiện đại, sẽ mang đến cho bạn cảm giác tự tin và thoải mái tuyệt đối. Đặc biệt hơn, với họa tiết chữ logo thươ', 'https://product.hstatic.net/200000642007/product/07pcs_3adrr0134_1_78c914f0ca4a40209566855eb1de922c_dbb6793d4e554a87854bd64e2fb2aae7_master.jpg', 'Áo sơ mi denim unisex cổ bẻ tay dài phom suông thời trang', 4490000, 0, 1),
(39, 4, 'Bỏ qua những chiếc áo sơ mi basic vốn có, cùng làm mới tủ đồ MLB với họa tiết monogram độc đáo mùa hè này. Hãy \"biến hóa\" phong cách tươi mới cho bản thân bằng sơ mi hoa tiết mang vẻ phóng khoáng nhưng không kém phần năng động cho giới trẻ.', 'https://product.hstatic.net/200000642007/product/50whs_3awsm0533_2_1c814d4400434ae893d32b0c4cab6de1_87345655e0214e778f96f65ee45e2aad_master.jpg', 'Áo sơ mi unisex cổ bẻ tay ngắn Mega Dia Monogram', 3590000, 3190000, 1),
(40, 4, 'Bỏ qua những chiếc áo sơ mi basic vốn có, cùng làm mới tủ đồ MLB với họa tiết monogram độc đáo mùa hè này. Hãy \"biến hóa\" phong cách tươi mới cho bản thân bằng sơ mi hoa tiết mang vẻ phóng khoáng nhưng không kém phần năng động cho giới trẻ.', 'https://product.hstatic.net/200000642007/product/07sbs_3awsm0533_2_4ca1ab41c64c40148e3c1ab44a2909f2_1a30367667d6491e887a7d9116b83116_master.jpg', 'Áo sơ mi unisex cổ bẻ tay ngắn Mega Dia Monogram', 3590000, 0, 1),
(41, 5, 'Áo hoodie Basic Small Logo có thiết kế đơn giản với logo MLB được thêu nhỏ gọn ở phần trước trên nền chất vải mềm mại, phù hợp cho cả nam và nữ. Dù bạn cần một chiếc áo tối giản trong mùa lạnh hay chỉ muốn tạo điểm nhấn cho trang phục, chiếc áo hoodie Bas', 'https://product.hstatic.net/200000642007/product/50bks_3ahdb0134_2_dcebb0cc2ab446a9869c4a83062b9f5c_eba280853cc44e24ae44597c4c46d938_master.jpg', 'Áo hoodie unisex tay dài phối mũ Basic Small Logo', 2590000, 2190000, 1),
(42, 5, 'Áo hoodie Basic Small Logo có thiết kế đơn giản với logo MLB được thêu nhỏ gọn ở phần trước trên nền chất vải mềm mại, phù hợp cho cả nam và nữ. Dù bạn cần một chiếc áo tối giản trong mùa lạnh hay chỉ muốn tạo điểm nhấn cho trang phục, chiếc áo hoodie Bas', 'https://product.hstatic.net/200000642007/product/50crs_3ahdb0134_1_8670c34f673447069784fb06a93df687_3b4e3fa879724b04bfb45a258e59c748_master.jpg', 'Áo hoodie unisex tay dài phối mũ Basic Small Logo', 2590000, 0, 1),
(43, 5, 'Chiếc áo hoodie Checkerboard Big Lux Mega là sự kết hợp hoàn hảo giữa phong cách thể thao và thời trang đường phố, mang đến một diện mạo độc đáo và riêng biệt dành cho bạn. Với hình ảnh logo MLB được in lớn ở mặt sau áo, đây sẽ là điểm nhấn thú vị để  giú', 'https://product.hstatic.net/200000642007/product/43crs_3ahdo0134_1_dc86c45439d94bd6b91424b0c3e038f6_7e523f4e5da5495fa63c7094e56b1384_master.jpg', 'Áo hoodie unisex tay dài phối mũ Checkerboard Big Lux Mega', 3290000, 3000000, 1),
(44, 5, 'Chiếc áo hoodie Checkerboard Big Lux Mega là sự kết hợp hoàn hảo giữa phong cách thể thao và thời trang đường phố, mang đến một diện mạo độc đáo và riêng biệt dành cho bạn. Với hình ảnh logo MLB được in lớn ở mặt sau áo, đây sẽ là điểm nhấn thú vị để  giú', 'https://product.hstatic.net/200000642007/product/50bks_3ahdo0134_9_884400e78aa14e5e8a1c5ab6209e047c_9de60b37899445a9b1db5acecb17830d_master.jpg', 'Áo hoodie unisex tay dài phối mũ Checkerboard Big Lux Mega', 3290000, 0, 1),
(45, 5, 'Hãy để chiếc áo hoodie Cube Monogram Big Lux giúp bạn thể hiện phong cách thể thao và thời trang đường phố độc đáo của mình. Với hình ảnh logo MLB được in nhỏ ở trước áo, đây sẽ là điểm nhấn thú vị giúp bạn ghi lại những dấu ấn khó quên c', 'https://product.hstatic.net/200000642007/product/50bks_3ahdm0334_9_6403517969a24d31b342dfa78ff280ae_ef9f788fabb54e77be2dc4b8c5a8d283_master.jpg', 'Áo hoodie unisex tay dài Cube Monogram Big Lux', 3290000, 3000000, 1),
(46, 5, 'Hãy để chiếc áo hoodie Cube Monogram Big Lux giúp bạn thể hiện phong cách thể thao và thời trang đường phố độc đáo của mình. Với hình ảnh logo MLB được in nhỏ ở trước áo, đây sẽ là điểm nhấn thú vị giúp bạn ghi lại những dấu ấn khó quên c', 'https://product.hstatic.net/200000642007/product/50crs_3ahdm0334_10_4c3ce5b8f808499eba35c1730aa81cc0_daf85b970723480286dd80f9afafe878_master.jpg', 'Áo hoodie unisex tay dài Cube Monogram Big Lux', 3290000, 3190000, 1),
(47, 5, 'Hãy khám phá sự kết hợp hoàn hảo giữa phong cách năng động và ấm áp với chiếc áo hoodie Basic Mega Logo Overfit Brushed đến từ thương hiệu MLB. Được thiết kế để mang đến cho các MLB-crew những bản phối đầy sáng tạo và cá tính, chiếc áo này hứa hẹn sẽ là đ', 'https://product.hstatic.net/200000642007/product/07whs_3ahdb0336_10_e58d11e30b794db7ab7e8de0f6b7a4e7_99a90290ade94f22aa0c9e111213f899_master.jpg', 'Áo hoodie unisex tay dài phối mũ Basic Mega Logo Overfit Brushed', 3590000, 3290000, 1),
(48, 5, 'Hãy khám phá sự kết hợp hoàn hảo giữa phong cách năng động và ấm áp với chiếc áo hoodie Basic Mega Logo Overfit Brushed đến từ thương hiệu MLB. Được thiết kế để mang đến cho các MLB-crew những bản phối đầy sáng tạo và cá tính, chiếc áo này hứa hẹn sẽ là đ', 'https://product.hstatic.net/200000642007/product/43mgs_3ahdb0336_9_517bdcf399754cf2845df8c7f4771c23_dd08e3dcd70145aa9a8d5c89f11a85b4_master.jpg', 'Áo hoodie unisex tay dài phối mũ Basic Mega Logo Overfit Brushed', 3390000, 3090000, 1),
(49, 5, 'Hãy khám phá sự kết hợp hoàn hảo giữa phong cách năng động và ấm áp với chiếc áo hoodie Basic Mega Logo Overfit Brushed đến từ thương hiệu MLB. Được thiết kế để mang đến cho các MLB-crew những bản phối đầy sáng tạo và cá tính, chiếc áo này hứa hẹn sẽ là đ', 'https://bizweb.dktcdn.net/100/393/859/products/eb53e2374159d9a8f268f94a39f8db3f-1664623917592.jpg?v=1666778064260', 'Áo hoodie unisex tay dài phối mũ Basic Mega Logo Overfit Brushed', 3690000, 3390000, 1),
(50, 5, '', 'https://cdn.becungshop.vn/images/500x500/ao-hoodie-dang-croptop-we-bare-bear-xinh-xan-cho-be-gai-p2528020dea497-500x500.jpg', 'Áo hoodie dáng croptop WE BARE BEAR xinh xắn cho bé gái CBG40731P', 2590000, 2090000, 1),
(51, 6, 'Bứt phá mọi giới hạn về phong cách với chiếc quần jogger Varsity Logo. Sở hữu kiểu dáng jogger năng động, thoải mái cùng điểm nhấn logo Varsity Logo nổi bật, đây hứa hẹn sẽ là lựa chọn hoàn hảo cho những hoạt động thể thao, tập gym, đi chơi hay dạo phố.', 'https://product.hstatic.net/200000642007/product/50crs_3aptv0141_1_03bb6cb87c6a4a11943ca6ab26606bd8_7bccdab9d3dd432db4d38123e3163ec4_master.jpg', 'Quần jogger unisex lưng thun Varsity Logo', 2790000, 2590000, 1),
(52, 6, 'Bứt phá mọi giới hạn về phong cách với chiếc quần jogger Varsity Logo. Sở hữu kiểu dáng jogger năng động, thoải mái cùng điểm nhấn logo Varsity Logo nổi bật, đây hứa hẹn sẽ là lựa chọn hoàn hảo cho những hoạt động thể thao, tập gym, đi chơi hay dạo phố.', 'https://product.hstatic.net/200000642007/product/50bks_3aptv0141_1_f1b9d99a86a74625a792b7123bba8bc9_41a338ec0606440aa493c93e02ffdfab_master.jpg', 'Quần jogger unisex lưng thun Varsity Logo', 2590000, 2390000, 1),
(53, 6, 'Được thiết kế dành riêng cho những tín đồ MLB thực thụ, chiếc quần jogger Basic Small Logo Cargo sẽ chiếm trọn cảm tình của bạn ngay từ cái nhìn đầu tiên. Với thiết kế năng động, cá tính cùng logo MLB nổi bật, chiếc quần sẽ giúp bạn tự tin thể hiện phong ', 'https://product.hstatic.net/200000642007/product/50bks_3aptb0641_1_c69b09aca7074a5ea587f0d1d168e128_4fe2a28ea0364c1fadd58d55a344f3b1_master.jpg', 'Quần jogger unisex lưng thun Basic Small Logo Cargo', 2990000, 2790000, 1),
(54, 6, 'Mang trong mình sự tối giản thời thượng nhưng lại vô cùng đa nhiệm, chiếc quần jogger đến từ MLB sẽ là must-have-item mà không một tín đồ nào có thể thiếu trong bộ sưu tập của mình. Không chỉ được làm từ chất liệu cotton mềm mại, thấm hút mồ hôi tốt mang ', 'https://product.hstatic.net/200000642007/product/50bks_3aptv0134_2_f1e6b5b3e0e049889842bd5a66b2e1ec_92a6ffbed7fe4699a7150f2eb2e772c4_master.jpg', 'Quần jogger unisex lưng thun phối logo thời trang', 2290000, 1999000, 1),
(55, 6, 'Hãy biến đổi phong cách hằng ngày của bạn thêm phần năng động và thoải mái cùng chiếc quần jogger Basic Mega Logo. Được làm từ chất liệu cao cấp mang lại sự mềm mại và thoáng mát cùng thiết kế hiện đại, bạn có thể dễ dàng kết hợp chiếc quần này với một ch', 'https://product.hstatic.net/200000642007/product/43mgl_3aptb0434_1_6f919a6a9beb4e13be7c8b6d34011536_90d8820446424a5cba555787b64286df_master.jpg', 'Quần jogger unisex Basic Mega Logo', 2490000, 2290000, 1),
(56, 6, 'Thể hiện đẳng cấp đầy thời thượng với chiếc quần jogger Diamond Monogram Jacquard. Được thiết kế với họa tiết monogram đặc trưng của thương hiệu MLB, bạn chỉ cần mix-match đơn giản cùng một chiếc sweatshirt hay áo thun là đã có thể tạo nên một bản phối ma', 'https://product.hstatic.net/200000642007/product/50crd_3aptm0134_1_f0fb9863e77742e28e42a3ea36cadd1f_69088504b852435db36528e302574a00_master.jpg', 'Quần jogger unisex lưng thun Diamond Monogram Jacquard', 3890000, 0, 1),
(57, 6, 'Thể hiện đẳng cấp đầy thời thượng với chiếc quần jogger Diamond Monogram Jacquard. Được thiết kế với họa tiết monogram đặc trưng của thương hiệu MLB, bạn chỉ cần mix-match đơn giản cùng một chiếc sweatshirt hay áo thun là đã có thể tạo nên một bản phối ma', 'https://product.hstatic.net/200000642007/product/50bks_3aptm0134_1_cb8c2617554c4f928a3efd4ec6ebddf0_94c6834dcc5f435ca619da81450430ea_master.jpg', 'Quần jogger unisex lưng thun Diamond Monogram Jacquard', 3590000, 0, 1),
(58, 6, 'Biến đổi phong cách của bạn với sự năng động của chiếc quần jogger Cube Monogram Big Lux. Được thiết kế để mang lại sự thoải mái và đa năng, item này sử dụng chất liệu 100% cotton cao cấp nhằm đảm bảo sự mềm mại và thoáng mát cho những người yêu thích thờ', 'https://product.hstatic.net/200000642007/product/43mgs_3aptm0834_1_73d554dd56094f2ba735895e26b46a59_f6733059039e43eb835715a3e8b5b030_master.jpg', 'Quần jogger unisex lưng thun Cube Monogram Big Lux', 2990000, 2690000, 1),
(59, 6, 'Chiếc quần jogger Varsity Logo đầy cá tính và năng động này là một sự bổ sung không thể thiếu cho những người yêu thích phong cách thể thao. Được làm từ chất liệu cao cấp, mềm mại, chiếc quần jogger này hứa hẹn sẽ đem lại cho bạn cảm giác thoải mái tối đa', 'https://product.hstatic.net/200000642007/product/43bgd_3aptv0134_1_41b7fff5c1f240e19f9b4dd865f4130d_fc0da194bb8f4d8b95851a37ef0e954d_master.jpg', 'Quần jogger unisex lưng thun Varsity Logo', 2690000, 0, 1),
(60, 6, '', 'https://product.hstatic.net/200000642007/product/50ivs_3aptd0131_1_d22300478dac4a7db299ad9fca297cce_ad27faa2b96c4c638070df65def763bc_master.jpg', 'Quần jogger unisex lưng thun Medium Logo Organic', 2590000, 2290000, 1),
(61, 7, '', 'https://product.hstatic.net/200000642007/product/50bks_3asmb0333_1_71e949cff86245e5a4a4f5867003dc62_f2be584a17254c6ebe422ac608d17c1a_master.jpg', 'Quần shorts unisex ống rộng Basic Medium Logo 7.5 In Summer', 1590000, 0, 1),
(62, 7, '', 'https://product.hstatic.net/200000642007/product/43sal_3lspm0133_1_520a9e6020bd468f843e9f9691acf134_540c52da29f048bbb65a6104a2f2e8f5_master.jpg', 'Quần shorts nam ống rộng Dia Monogram Full Board', 2490000, 2290000, 1),
(63, 7, 'Thổi bay nỗi lo chẳng có gì để mặc với chiếc quần shorts ống rộng siêu thoải mái và tiện dụng. Với phom dáng kinh điển trên nền chất liệu thoáng mát phối cùng họa tiết logo tinh tế, chỉ cần mix&match đơn giản cùng một chiếc áo polo hoặc sơ mi là bạn đã sở', 'https://product.hstatic.net/200000642007/product/50mgl_3aspv0143_1_8c2abf1c535e4d9ba809e8ac58357b75_master.jpg', 'Quần shorts unisex ống rộng lưng thun trẻ trung', 1790000, 1390000, 1),
(64, 7, 'Thổi bay nỗi lo chẳng có gì để mặc với chiếc quần shorts ống rộng siêu thoải mái và tiện dụng. Với phom dáng kinh điển trên nền chất liệu thoáng mát phối cùng họa tiết logo tinh tế, chỉ cần mix&match đơn giản cùng một chiếc áo polo hoặc sơ mi là bạn đã sở', 'https://product.hstatic.net/200000642007/product/50bks_3aspv0143_1_83089ad353054fecb4e4b7040fdbb9a3_master.jpg', 'Quần shorts unisex ống rộng lưng thun trẻ trung', 1790000, 0, 1),
(65, 7, 'Với những ngày khó khăn trong việc lựa chọn trang phục nhưng vẫn muốn sở hữu cho mình một bản phối năng động, thì hãy diện ngay chiếc quần shorts đến từ thương hiệu MLB và tự tin dạo bước xuống phố. Được thiết kế từ chất liệu vải cotton mềm mại và họa tiế', 'https://product.hstatic.net/200000642007/product/50pkl_3aspm0134_1_2b3dd91abfcc4de39735d07aa1152dbb_86cd364428e545e7978d509cee284ebe_master.jpg', 'Quần shorts unisex ống rộng Classic Monogram All Over Jacquard', 2590000, 2390000, 1),
(66, 7, 'Với những ngày khó khăn trong việc lựa chọn trang phục nhưng vẫn muốn sở hữu cho mình một bản phối năng động, thì hãy diện ngay chiếc quần shorts đến từ thương hiệu MLB và tự tin dạo bước xuống phố. Được thiết kế từ chất liệu vải cotton mềm mại và họa tiế', 'https://product.hstatic.net/200000642007/product/50crd_3aspm0134_1_ea9de06f469c4b1d9a4dad96bd48b230_b925aabad1c4400c9e948effeb553de5_master.jpg', 'Quần shorts unisex ống rộng Classic Monogram All Over Jacquard', 2590000, 0, 1),
(67, 7, '', 'https://product.hstatic.net/200000642007/product/43mgs_3aspb0233_1_775de161008543ec9a3dd7b26fc99aab_75a127c121b74b8cabe4a6affc0efc5a_master.jpg', 'Quần shorts unisex ống rộng Basic Megalogo Part 7', 1790000, 1590000, 1),
(68, 7, '', 'https://product.hstatic.net/200000642007/product/50sbl_3ldpi0133_2_af913f581deb48af9d0c43d6c9705301_bff47942114249f7b747959c6edd9e13_master.jpg', 'Quần shorts jeans nam lưng thun thời trang', 3190000, 2990000, 1),
(69, 7, '', 'https://product.hstatic.net/200000642007/product/43bgd_3lsmb0633_1_7eb67ec3e83c45d5a5a339710f1bdb3b_d3323ae6c5fe42ab9fd823a639093ed8_master.jpg', 'Quần shorts ngang gối nam Basic Medium Logo Bermuda', 2190000, 0, 1),
(70, 7, '', 'https://product.hstatic.net/200000642007/product/07bll_3aspb0433_1_0fef6edb09a44c42b418409638b932e0_886b974204e64e5cb8af6ed3fa4a2e20_master.jpg', 'Quần shorts unisex ống rộng Basic Medium Logo 7 In', 1590000, 1290000, 1),
(71, 8, 'Chiếc quần jeans từ MLB được thiết kế với kiểu dáng ống rộng thoải mái sẽ mang đến sự năng động và trẻ trung cho bạn. Điểm nhấn ấn tượng của chiếc quần chính là logo đội bóng được thêu tỉ mỉ, tinh tế trên nền chất liệu denim cao cấp, mềm mại, tạo cảm giác', 'https://product.hstatic.net/200000642007/product/50pkm_3fdpv0141_1_10a21cd5bb9f4cfdb0481773bfb5f2c2_4d00693a2a44492585154b6056e8821e_master.jpg', 'Quần jeans nữ ống rộng thời trang', 4090000, 0, 1),
(72, 8, 'Sở hữu gam màu thanh lịch trên nền chất liệu denim quen thuộc, chiếc quần jeans Basic Embroidery Logo sẽ là điểm nhấn hoàn hảo cho mọi outfit của bạn. Thuộc bộ sưu tập Multi Mega Logo Denim, chiếc quần gây ấn tượng với thiết kế ống rộng thoải mái đã nhanh', 'https://product.hstatic.net/200000642007/product/50bll_3fdpb0241_10_cbac171c386149cd8bae648b1e790606_35131f4cbdcd4410b69352fd00bf1561_master.jpg', 'Quần jeans nữ ống rộng Basic Embroidery Logo', 4990000, 4590000, 1),
(73, 8, 'Tự tin khẳng định phong cách thời thượng cùng chiếc quần jeans ống rộng Basic Megalogo. Với chất liệu vải mềm mịn trên từng đường may tỉ mỉ, kết hợp cùng họa tiết monogram ấn tượng, Basic Megalogo không chỉ mang đến sức hút đầy cá tính cho tổng thể mà còn', 'https://product.hstatic.net/200000642007/product/50ins_3fdpb0741_1_5f6cfa543750435e9ece7f17c7d1f637_c26e55f88abf47129bcacade276eea16_master.jpg', 'Quần jeans nữ ống rộng Basic Megalogo', 4290000, 3990000, 1),
(74, 8, 'Hãy sẵn sàng khuấy đảo mọi ánh nhìn với chiếc quần jogger Sportive Varsity High Waist! Được thiết kế hài hòa từ sự kết hợp giữa phong cách năng động và nét cá tính thời thượng, item này hứa hẹn sẽ đồng hành cùng bạn trên mọi chặng đường bất kể mọi hoạt độ', 'https://product.hstatic.net/200000642007/product/50ivs_3fptv0241_1_59aaf0c51b7d4fceb7733f22be108c51_7dd9019fdc4244f9a4185648205830f7_master.jpg', 'Quần jogger nữ lưng thun Sportive Varsity High Waist', 3190000, 0, 1),
(75, 8, 'Hãy sẵn sàng khuấy đảo mọi ánh nhìn với chiếc quần jogger Sportive Varsity High Waist! Được thiết kế hài hòa từ sự kết hợp giữa phong cách năng động và nét cá tính thời thượng, item này hứa hẹn sẽ đồng hành cùng bạn trên mọi chặng đường bất kể mọi hoạt độ', 'https://product.hstatic.net/200000642007/product/50bks_3fptv0241_1_574cb40d6e294df7a3ede1071d86f0c1_1d5d9cc24d784b56890f2325d73dc9fc_master.jpg', 'Quần jogger nữ lưng thun Sportive Varsity High Waist', 3190000, 3000000, 1),
(76, 8, 'Nâng tầm phong cách thời thượng một cách nhịp nhàng với chiếc quần Athleisure Classic Monogram Jacquard. Với thiết kế ống loe lấy cảm hứng từ phong cách retro nhưng được làm từ chất liệu vải mềm mại và thoải mái, kết hợp cùng điểm nhấn ', 'https://product.hstatic.net/200000642007/product/50bks_3fptm2134_1_d44cb5384ac14b6e9dda30aeb011e1ae_a23ea4fc0557403ab5ff678a9962c770_master.jpg', 'Quần nữ ống loe Athleisure Classic Monogram Jacquard', 3890000, 3590000, 1),
(77, 8, 'Chiếc quần jogger Basic Athleisure Medium Logo với thiết kế tối giản được nhấn nhá bằng chi tiết logo tinh tế trên nền chất liệu vải thoáng mát đã tạo nên một item hoàn hảo cho phong cách thường nhật, chắc chắn sẽ đem đến cho bạn sự năng động cũng như tự ', 'https://product.hstatic.net/200000642007/product/07cbl_3fptb2234_2_0c093f6088264ac88df0ca830262b798_6f3150c471024ae0b5ece9d8ab9ab5a8_master.jpg', 'Quần jogger nữ lưng thun Basic Athleisure Medium Logo', 2790000, 0, 1),
(78, 8, 'Trải nghiệm cuộc sống đầy phong cách cùng chiếc quần jeans có thiết kế phom suông ống rộng độc đáo này. Với khả năng kết hợp linh hoạt các items khác, đây chính là chiếc quần hoàn hảo để bạn có thể tự do sáng tạo mix&match trong mọi tình huống. Đừng chần ', 'https://product.hstatic.net/200000642007/product/50ins_3fdpr0134_1_4eca0efb2328416d9f63a53eafc50157_218b47255c274a04a031934fb7717bb5_master.jpg', 'Quần jeans nữ ống rộng phối logo thời trang', 4490000, 4190000, 1),
(79, 8, 'Chiếc quần jeans Multi Mega Logo được làm từ chất liệu jean đầy cuốn hút, có thiết kế phom ống rộng thoải mái trên nền gam màu thời thượng đã nhanh chóng trở thành món đồ hoàn hảo cho những ngày bạn không biết mặc gì. Chỉ cần phối cùng một chiếc áo thun đ', 'https://product.hstatic.net/200000642007/product/43crm_3fdpb0334_1_118f6ef0d198422b972d2878d36f4359_8af09d87efd547b299b56b098340f1b7_master.jpg', 'Quần jeans nữ ống rộng Multi Mega Logo', 4790000, 4590000, 1),
(80, 8, 'Chuyển động nhịp nhàng đầy thời thượng với chiếc quần Athleisure Small Logo Bootcut đến từ thương hiệu MLB. Với thiết kế ống loe lấy cảm hứng từ phong cách retro nhưng được làm từ chất liệu thun thể thao vô cùng năng động và thoả', 'https://product.hstatic.net/200000642007/product/50bks_3flgb0334_7_36119d9cf4414e1bb313c52f99ad6f1c_9a42cd739e544815a390819e98413b7c_master.jpg', 'Quần nữ ống loe Athleisure Small Logo Bootcut', 2090000, 0, 1),
(81, 9, 'MLB mang đến cho bạn chiếc chân váy denim Basic Multi Megalogo Print, bản tuyên ngôn cho phong cách cá tính và thời thượng. Nổi bật với họa tiết monogram tạo điểm nhấn ấn tượng trên nền vải jean bền bỉ, phối cùng thiết kế nút cài kim lại và chi tiết 5 túi', 'https://product.hstatic.net/200000642007/product/50ins_3fdsb0143_1_48676846a3124d11ab4145d431f947db_024e4d7cf717459f9b9a61af5a141548_master.jpg', 'Chân váy denim mini phom chữ A Basic Multi Megalogo Print', 3290000, 0, 1),
(82, 9, 'MLB mang đến cho bạn chiếc chân váy denim Basic Multi Megalogo Print, bản tuyên ngôn cho phong cách cá tính và thời thượng. Nổi bật với họa tiết monogram tạo điểm nhấn ấn tượng trên nền vải jean bền bỉ, phối cùng thiết kế nút cài kim lại và chi tiết 5 túi', 'https://product.hstatic.net/200000642007/product/07crs_3fdsb0143_1_5da22b40945742b0806d824bffc00301_242185a4c97841a5b0d435aec5f69358_master.jpg', 'Chân váy denim mini phom chữ A Basic Multi Megalogo Print', 3290000, 3000000, 1),
(83, 9, 'Chiếc chân váy chữ A Monogram sẽ là nét chấm phá cá tính cho phong cách thời trang của mọi cô gái cá tính. Với sự kết hợp hoàn hảo giữa nét năng động, trẻ trung của denim và họa tiết monogram thời thượng, item này chính là bí quyết để hoàn thiện mọi outfi', 'https://product.hstatic.net/200000642007/product/50ins_3fdsm0343_2_e16bd03210ca41bf8d4d8906e7bc421c_master.jpg', 'Chân váy denim mini phom chữ A Monogram', 3790000, 3590000, 1),
(84, 9, 'Cần gì cầu kỳ khi chỉ cần mix-match đơn giản cùng chiếc chân váy Classic Sports Accordion Pleated là bạn đã sở hữu ngay cho mình một vẻ ngoài vừa năng động vừa cá tính. Với thiết kế phom dáng xếp li nữ tính và chi tiết logo tinh tế trên phần lưng thun, tấ', 'https://product.hstatic.net/200000642007/product/50crd_3fskg0334_2_2d8661e262bf41c0aaeff9d349181563_8faa7485f7384b08927c430971babc55_master.jpg', 'Chân váy xếp li mini Classic Sports Accordion Pleated', 3290000, 0, 1),
(85, 9, 'Cần gì cầu kỳ khi chỉ cần mix-match đơn giản cùng chiếc chân váy Classic Sports Accordion Pleated là bạn đã sở hữu ngay cho mình một vẻ ngoài vừa năng động vừa cá tính. Với thiết kế phom dáng xếp li nữ tính và chi tiết logo tinh tế trên phần lưng thun, tấ', 'https://product.hstatic.net/200000642007/product/07nyd_3fskg0334_1_8261d6e584184889b7539a0ed2812946_90cec2b157494a7e85f90278c5880d19_master.jpg', 'Chân váy xếp li mini Classic Sports Accordion Pleated', 3290000, 2990000, 1),
(86, 9, 'Nâng tầm phong cách thêm phần năng động với chiếc chân váy xếp li Classic Sports Striped Knit Pleated. Với thiết kế phom dáng mini kết hợp cùng gam màu thời thượng và chi tiết logo tinh tế, chiếc váy không chỉ giúp bạn dễ dàng mix&match từ áo thun cho đến', 'https://product.hstatic.net/200000642007/product/43crd_3fskg0236_1_7e4bec2e85ed4df5b8890ae27bfa3ab7_78bdc3bc99b04ac4a93c79151f7d9aef_master.jpg', 'Chân váy xếp li mini Classic Sports Striped Knit Pleated', 4690000, 4290000, 1),
(87, 9, 'Chiếc chân váy xếp li Classic Sports Pleated hứa hẹn sẽ là món phụ kiện hoàn hảo để bạn bổ sung vào bộ sưu tập của mình. Nhờ vào thiết kế mini vừa vặn cùng chi tiết xếp li độc đáo và điểm nhấn logo tinh tế, item này sẽ giúp bạn tạo nên những bản phối vừa ', 'https://product.hstatic.net/200000642007/product/45pks_3fskg0134_1_ac3dfed5e32a4a8c86594295bc25e651_cfe5f00ca3e546dfbdf29c3b9127c13e_master.jpg', 'Chân váy xếp li mini Classic Sports Pleated', 3290000, 0, 1),
(88, 9, '', 'https://product.hstatic.net/200000642007/product/07sbs_3fskb0133_1_486187427f77408fa0750f7105cab1f7_141f28628a464cb6a07f4b2af083e025_master.jpg', 'Chân váy xếp li mini Basic Small Logo', 2690000, 0, 1),
(89, 9, '', 'https://product.hstatic.net/200000642007/product/50gnn_3fskm0133_2_df28ddce1b304c6d958ad2535c03e340_a7e116e42454467eab62089dca7a9f4a_master.jpg', 'Chân váy xếp li mini Classic Monogram', 3190000, 0, 1),
(90, 9, 'Chiếc chân váy xếp li Classic Sports Pleated hứa hẹn sẽ là món phụ kiện hoàn hảo để bạn bổ sung vào bộ sưu tập của mình. Nhờ vào thiết kế mini vừa vặn cùng chi tiết xếp li độc đáo và điểm nhấn logo tinh tế, item này sẽ giúp bạn tạo nên những bản phối vừa ', 'https://product.hstatic.net/200000642007/product/50bks_3fskg0134_1_ef005b651d1949f0bf96c65f651c9432_949cbc9a69dd4362b0e600bf1ea932c7_master.jpg', 'Chân váy xếp li mini Classic Sports Pleated', 3290000, 0, 1),
(91, 10, 'Đôi dép quai ngang đơn giản nhưng hiện đại với phom đế cao chunky cùng phần quai dép cách điệu độc đáo. Không cần cầu kì, đôi dép này hoàn hảo để phối với nhiều loại trang phục, mang đến cho bạn vẻ ngoài năng động, cá tính.', 'https://product.hstatic.net/200000642007/product/07whs_3alpfbs33_2_7948cc3a4f604ea587ceaaec075d5e41_7626992d4bb54efabca54f4c24f63988_master.jpg', 'Dép unisex quai ngang bản rộng Chunky Bouncer', 1990000, 0, 1),
(92, 10, '', 'https://product.hstatic.net/200000642007/product/50bkl_3alpad333_1_13e3f93c79d842278ac2062b157e6b48_399d146110e542ea968046599ec5fa2a_master.jpg', 'Dép quai ngang unisex New Mound', 1390000, 1190000, 1),
(93, 10, '', 'https://product.hstatic.net/200000642007/product/43crs_3alpcdm33_1_1d1e01032cfa44a1877c369bbc3803d7_55f953c4e9ad448da31cc1a6b36c7487_master.jpg', 'Dép quai ngang unisex Chunky Mound Diamond Monogram', 1690000, 0, 1),
(94, 10, '', 'https://product.hstatic.net/200000642007/product/50bks_3alpcdm33_1_8b20e7bf2b824da4b1f7be5cf9aa3d9a_55117cdf58ff477b90bf4199088c1e96_master.jpg', ' Dép quai ngang unisex Chunky Mound Diamond Monogram', 1690000, 1290000, 1),
(95, 10, 'Đắm chìm trong sự năng động và phá cách cùng đôi giày sneakers Chunky Runner SD. Sở hữu hai gam màu đa dạng trên nền chất liệu da cao cấp tạo nên vẻ ngoài thu hút mọi ánh nhìn, Chunky Runner SD còn có phần đế giày EVA cao su mang đến sự êm ái, thoải mái c', 'https://product.hstatic.net/200000642007/product/07sbs_3ashcrs3n_3_c436597a6511408e964de7fbea7536c5_4a00102e7e484c469662fef2615b6fdb_master.jpg', 'Giày sneakers unisex cổ thấp Chunky Runner SD', 3690000, 0, 1),
(96, 10, 'Đắm chìm trong xu hướng thời trang đường phố cùng đôi giày sneakers BigBall Chunky Window Monogram. Được thiết kế độc đáo với đế giày 3 lớp êm ái phối cùng logo đội bóng chày nổi bật, item này sẽ khẳng định đẳng cấp thời trang đường phố cũng như mang đến ', 'https://product.hstatic.net/200000642007/product/50bks_3ashbwm4n_2_e76b425bfe92442bad70fe9886c8e904_26f034fadc1e4fd8bbe347069039defd_master.jpg', 'Giày sneakers unisex cổ thấp Bigball Chunky Window Monogram', 3690000, 3390000, 1),
(97, 10, 'Đắm chìm trong sự ngọt ngào và cá tính cùng đôi giày sneakers Bigball Chunky Pastel đến từ MLB. Với thiết kế phom dáng đặc trưng nhưng được biến tấu đầy ngọt ngào cùng các gam màu pastel tinh tế, item này sẵn sàng cùng bạn tự tin thể hiện cá tính và phong', 'https://product.hstatic.net/200000642007/product/07sbl_3ashbpn3n_2_5b008ed389e8479285d3d23591df6d2b_a26a9c34f9d849d29acff6c0c29383c1_master.jpg', 'Giày sneakers unisex cổ thấp Bigball Chunky Pastel', 3290000, 0, 1),
(98, 10, 'Đắm chìm trong sự ngọt ngào và cá tính cùng đôi giày sneakers Bigball Chunky Pastel đến từ MLB. Với thiết kế phom dáng đặc trưng nhưng được biến tấu đầy ngọt ngào cùng các gam màu pastel tinh tế, item này sẵn sàng cùng bạn tự tin thể hiện cá tính và phong', 'https://product.hstatic.net/200000642007/product/50ldl_3ashbpn3n_2_a8b24d2e4cd747328c7ffe6e1cac1a1e_f45e993d593f47cdaf81dac94a83c49e_master.jpg', 'Giày sneakers unisex cổ thấp Bigball Chunky Pastel', 3290000, 0, 1),
(99, 10, 'Với thiết kế phom dáng chunky vừa cổ điển vừa trẻ trung, đôi giày sneakers Chunky Liner Mid Denim chính là người bạn đồng hành hoàn hảo để cùng bạn thể hiện phong cách đầy năng động của mình. Nổi bật với họa tiết monogram kết hợp cùng logo độc quyền của t', 'https://product.hstatic.net/200000642007/product/50grs_3asxcdn3n_2_ed0db27654b445798d21b11266c4ea4f_7684e630f99a42fabce8395d8c7c5d58_master.jpg', 'Giày sneakers unisex cổ thấp Chunky Liner Mid Denim', 4390000, 3990000, 1),
(100, 10, 'Khám phá sự kết hợp hoàn hảo giữa phong cách cá tính và thiết kế thể thao với đôi giày sneakers Chunky Liner Diamond Monogram. Được làm từ chất liệu da bền bỉ kết hợp cùng phần đế vững chắc giúp hỗ trợ tối đa mỗi bước đi của bạn, đôi giày còn được thiết k', 'https://product.hstatic.net/200000642007/product/07pks_3asxcbo3n_2_f8401cd4b5234fefa1427bbbac5803f1_fb20690e869344d68324dd565b78e364_master.jpg', 'Giày sneakers unisex cổ thấp Chunky Liner Diamond Monogram', 3590000, 0, 1),
(101, 11, 'Khám phá thế giới với phong cách năng động cùng balo Classic Monogram Jacquard Mini. Với ngăn chứa rộng rãi kết hợp cùng phom dáng hình chữ nhật cổ điển trên nền gam màu thời thượng, item này không chỉ phù hợp để mix&match với nhiều outfit mà còn là người', 'https://product.hstatic.net/200000642007/product/50crd_3abks014n_1_e2cf646213e34824831a4796f2a1aa8f_aebbd94ea325422dbd75a4ed172780d8_master.jpg', 'Balo unisex phom chữ nhật Classic Monogram Jacquard Mini', 3790000, 3590000, 1),
(102, 11, 'Balo Varsity Nylon với cảm hứng từ những chuyến phiêu lưu mạo hiểm sẽ là người bạn đồng hành không thể thiếu cho mọi cuộc hành trình của bạn. Sở hữu thiết kế rộng rãi cùng những chi tiết chữ thêu đầy phong cách và năng động, mỗi chi tiết của Varsity Nylon', 'https://product.hstatic.net/200000642007/product/43bgd_3abkm024n_1_682f8cd32f5b494db3a153d14aa317fd_6845ec4bb8024c8ebe1aca07970a6699_master.jpg', 'Balo unisex phom chữ nhật Varsity Nylon', 4790000, 4490000, 1),
(103, 11, '', 'https://product.hstatic.net/200000642007/product/43crs_3aors062n_1_0061eca06b5349779d9d5876f8ff1b8c_acf193db1a9b4dc28237a82e212c15c1_master.jpg', 'Túi đeo chéo unisex Basic Big Logo', 2890000, 2590000, 1),
(104, 11, 'Túi đeo chéo Classic Monogram Jacquard Mini là sự kết hợp hoàn hảo giữa vẻ năng động và phong cách vượt thời gian. Với thiết kế phom dáng hình chữ nhật cổ điển được tô điểm bởi logo thương hiệu nổi bật và dây đeo tùy chỉnh, tổng hòa của thiết kế đã tạo nê', 'https://product.hstatic.net/200000642007/product/50crd_3acrs014n_1_fb754e752caf44c181c8346766c92691_ae0b971c18464c48b42d63af990fdb2c_master.jpg', 'Túi đeo chéo unisex phom chữ nhật Classic Monogram Jacquard Mini', 2990000, 0, 1),
(105, 11, 'Túi đeo vai Classic Monogram Denim Hobo chính là sự kết hợp hoàn hảo giữa phong cách thời trang hiện đại và tinh thần thể thao năng động. Với phom dáng bán nguyệt được cách điệu họa tiết monogram thời thượng, item này sẵn sàng trở thành điểm nhấn lý tưởng', 'https://product.hstatic.net/200000642007/product/50ins_3abqs224n_1_0128f28902f94925b24ef0a2bffde688_911322a97390441c8f575295211fcd90_master.jpg', 'Túi đeo vai nữ chữ nhật Classic Monogram Denim Hobo', 3290000, 0, 1),
(106, 11, 'Điểm tô thêm sắc màu cuộc sống cùng chiếc túi đeo vai DiaMono Fur Hobo. Với thiết kế chần bông siêu mềm mại trên nền gam màu thời trang được nhấn nhá bằng họa tiết logo đầy độc đáo, chiếc túi sẽ mang đến vẻ ngoài rực rỡ, năng động cũng như giúp bạn tự tin', 'https://product.hstatic.net/200000642007/product/50crd_3abqm0836_3_597b2f1181794446aca3e76a50b7bd87_48f919a727054b67a54cf164607071ad_master.jpg', 'Túi đeo vai nữ phom bán nguyệt DiaMono Fur Hobo', 3390000, 3190000, 1),
(107, 11, '', 'https://product.hstatic.net/200000642007/product/43sbl_3abqs023n_1_aa3f0fa78d1d4a67ab288f673d6065cf_ebe6083b80d14f38a30f11f3e68b26ff_master.jpg', 'Túi đeo vai nữ Diamond Monogram Denimlike Hobo', 4390000, 0, 1),
(108, 11, 'Nổi bật giữa đám đông với túi tote Varsity Canvas Mini, item mang đến sự kết hợp hoàn hảo giữa họa tiết monogram đầy sắc màu và logo tinh tế. Với kích thước nhỏ gọn, tiện lợi cùng  kích thước rộng rãi có dây đeo điều chỉnh linh hoạt, chiếc túi cho phép bạ', 'https://product.hstatic.net/200000642007/product/07crd_3aors083n_1_c84eac5b650f4be79b9688c91d6efd66_02bbed11422b4c88a112eeaf40fea026_master.jpg', 'Túi tote nữ phom chữ nhật Varsity Canvas Mini', 3090000, 0, 1),
(109, 11, '', 'https://product.hstatic.net/200000642007/product/07gnl_3aorl0233_1_514e5a9f5f5244368fe70c01c65a2a89_a660711b0f6f41f887808b6e0c71ed59_master.jpg', 'Túi tote phom chữ nhật Gradation Monogram', 4990000, 4590000, 1),
(110, 11, '', 'https://product.hstatic.net/200000642007/product/50vos_3aorl0233_1_89e4f33dfbb04c678226114259fe0a9d_84bcf95ac20a42d1ac30347f105dd677_master.jpg', 'Túi tote phom chữ nhật Gradation Monogram', 4990000, 0, 1),
(111, 12, 'Chiếc nón bóng chày New Year Dragon Structured với gam màu tinh tế và hình ảnh chú rồng được thêu tỉ mỉ trên mặt bên là một item thú vị cho những ai yêu thích phong cách thời trang độc đáo và năng động. Đây chắc chắn là món phụ kiện không thể thiếu giúp b', 'https://product.hstatic.net/200000642007/product/50crs_3acpdr14n_1_be79e47f82bb41a38b0d9598525aa23b_255a19567c5043ddb1fd403384f118a3_master.jpg', 'Nón bóng chày unisex New Year Dragon Structure', 1390000, 0, 1),
(112, 12, 'Chiếc nón bóng chày New Year Dragon Structured với gam màu tinh tế và hình ảnh chú rồng được thêu tỉ mỉ trên mặt bên là một item thú vị cho những ai yêu thích phong cách thời trang độc đáo và năng động. Đây chắc chắn là món phụ kiện không thể thiếu giúp b', 'https://product.hstatic.net/200000642007/product/50bks_3acpdr14n_1_096b5ad3b58b4a72acbaf69f6ee9e869_7467f77e2a7c4fc89e65b4b450dc3704_master.jpg', 'Nón bóng chày unisex New Year Dragon Structure', 1390000, 1190000, 1),
(113, 12, 'Thêm chút bụi bặm và năng động vào bản phối thời trang hàng ngày của bạn cùng chiếc nón bóng chày Pop Varsity Structure. Với gam màu trung tính và các sticker vải nổi bật, chiếc nón không chỉ tạo điểm nhấn thú vị cho tổng thể trang phục mà còn là item hoà', 'https://product.hstatic.net/200000642007/product/07gnd_3acpv053n_1_2360a5384fcf43b8b1392a4d179fbf9d_3f0ffc8319b744a49b9c3570abb7580b_master.jpg', 'Nón bóng chày unisex Pop Varsity Structure', 1990000, 1590000, 1),
(114, 12, 'Dù trời nắng hay mưa thì chiếc nón bóng chày Mega Bear Unstructured vẫn là item không thể thiếu giúp các tín đồ thời trang hoàn thiện phong cách một cách trọn vẹn. Nổi bật với hình thêu chú gấu ngộ nghĩnh kết hợp cùng gam màu trung tính và phom dáng cứng ', 'https://product.hstatic.net/200000642007/product/50crd_3acpb023n_2_2993a9ea2cdf43278c68940f5e59a448_9c76dc17d0094467bcf52c6b2bfc04c1_master.jpg', 'Nón bóng chày unisex Mega Bear Unstructured', 990000, 0, 1),
(115, 12, '', 'https://product.hstatic.net/200000642007/product/05abs_3amcu0133_2_489c0116b34e48cabefa8d37e42e3ee2_92f2a7a63edf4ca69a11efd323c76a5d_master.jpg', 'Nón bóng chày unisex phối lưới Sunny Beach Mesh', 1390000, 1190000, 1);
INSERT INTO `products` (`product_id`, `product_category_id`, `product_description`, `product_image`, `product_name`, `product_price`, `product_sale_price`, `product_status`) VALUES
(116, 12, 'Lấy cảm hứng từ hiệp hội bóng chày MLB, chiếc nón bucket Fur sẽ mang đến cho bạn thiết kế hiện đại, trẻ trung với logo thêu sắc nét nổi bật trên nền gam màu tương phản. Có điểm nhấn là phần viền lông mềm mịn, mang đến sự sang trọng, thời thượng, item này ', 'https://product.hstatic.net/200000642007/product/50bks_3ahtf0936_1_c9cf06502bce48e7a8fe0acb0537c0d8_3e0c7c47ce1a4e178dbd374f3d41f3ae_master.jpg', 'Nón bucket unisex thời trang Fur', 2090000, 0, 1),
(117, 12, 'Lấy cảm hứng từ hiệp hội bóng chày MLB, chiếc nón bucket Fur sẽ mang đến cho bạn thiết kế hiện đại, trẻ trung với logo thêu sắc nét nổi bật trên nền gam màu tương phản. Có điểm nhấn là phần viền lông mềm mịn, mang đến sự sang trọng, thời thượng, item này ', 'https://product.hstatic.net/200000642007/product/43bgl_3ahtf0936_1_f68178ff70a741d4a1aeb4f1e3fffa92_b700f151391b4689988dda1700538e44_master.jpg', 'Nón bucket unisex thời trang Fur', 2090000, 1990000, 1),
(118, 12, 'Bứt phá khỏi những thiết kế đơn điệu, chiếc nón bucket Classic Monogram sẽ mang đến làn gió mới cho phong cách thời trang của bạn. Là sự kết hợp độc đáo giữa họa tiết monogram cùng màu sắc tương phản tạo nên điểm nhấn ấn tượng, chiếc nón sẽ là must-have-i', 'https://product.hstatic.net/200000642007/product/50sbd_3ahtm124n_1_68feacb7877347779c486c655b5f6577_85f1fef4198c421293101fd8e5115298_master.jpg', 'Nón bucket unisex thời trang Classic Monogram', 2190000, 2000000, 1),
(119, 12, 'Chiếc nón bucket Big Classic Monogram sẽ không bao giờ làm các tín đồ MLB thất vọng với thiết kế độc đáo đậm chất retro. Những dòng chữ thêu độc quyền ở chính giữa nón kết hợp cùng gam màu trung tính đã tạo nên một phong cách độc đáo mang tính biểu tượng,', 'https://product.hstatic.net/200000642007/product/50sal_3ahtv013n_1_6c7c9ec0fe3246b1a3b63caae1081573_d4c9bec9fe554487a1fc797d6170aa86_master.jpg', 'Nón bucket unisex Big Classic Monogram', 1590000, 1290000, 1),
(120, 12, 'Một chiếc nón bucket sẽ là điểm nhấn hoàn hảo cho outfit những ngày hè sắp tới của bạn. Với hoạ tiết monogram đặc trưng cùng chi tiết logo nổi bật ở phía trước, ánh nắng cũng sẽ không thể làm lu mờ bạn. Sẵn sàng khuấy động mùa hè thôi! ', 'https://product.hstatic.net/200000642007/product/07gnl_3ahtm0933_1_930734d6b35d4989ac057a393d3b5a50_a62b44e8f64b4662bb8f4e2862faf0d4_master.jpg', 'Nón bucket unisex Gradient Monogram', 1890000, 1290000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_name`, `role_description`) VALUES
('Admin', 'Admin role'),
('User', 'Default role for newly created record');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_name` varchar(255) NOT NULL,
  `user_active` int(11) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_avatar` varchar(255) DEFAULT NULL,
  `user_count` int(11) DEFAULT NULL,
  `user_current_time` int(11) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_full_name` varchar(255) DEFAULT NULL,
  `user_gender` int(11) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone_number` varchar(255) DEFAULT NULL,
  `user_unlock_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_name`, `user_active`, `user_address`, `user_avatar`, `user_count`, `user_current_time`, `user_email`, `user_full_name`, `user_gender`, `user_password`, `user_phone_number`, `user_unlock_time`) VALUES
('admin', 0, 'Ba Vì - Hà Nội', 'http://res.cloudinary.com/dxo2y5smg/image/upload/v1715758983/avatar/w7h3fidb4hrihitihcd0.jpg', 0, 0, 'admin@gmail.com', 'admin', 0, '$2a$10$eMeCv7K8X0SXXHQULWeQ8u8gKZgGYE.LR0Ac6oRj0prdA20NP8PSm', '0982467073', 0),
('tuanflute', 0, 'Ha Noi', 'http://res.cloudinary.com/dxo2y5smg/image/upload/v1715759179/avatar/dlog2z2uulqsqaeikjhd.jpg', 0, 0, 'tuanflute27052004@gmail.com', 'tuanflute275', 0, '$2a$10$Ytz8yjusXRd2MInh7NYlM.j7Zs8d5QIjQdXQhV11CxcKVySFe0Vte', '0982467073', 0),
('user', 0, 'Ba Vì - Hà Nội', NULL, 0, 0, 'user@gmail.com', 'user', 0, '$2a$10$5hB8UFwO8edFbxT5y5peC.LP2MNTH903Y.Oa6FVG/6RzT8JPianu2', '0386564543', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
('admin', 'Admin'),
('tuanflute', 'User'),
('user', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`blog_id`);

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `FKjvtescr8p5gnfwauss1f9s61t` (`product_product_id`),
  ADD KEY `FK150sonee311u9q6yoee6onyyf` (`user_user_name`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `coupons`
--
ALTER TABLE `coupons`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coupon_conditions`
--
ALTER TABLE `coupon_conditions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhqpecssefaknbbcmd78wrrnal` (`coupon_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FKn1d1gkxckw648m2n2d5gx0yx5` (`coupon_id`),
  ADD KEY `FKinlq3l5oq62ubxyn5dt74bn1q` (`user_user_name`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_detail_id`),
  ADD KEY `FKrws2q0si6oyd6il8gqe2aennc` (`order_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKp7dy0okc2p35dj70wl4grqlw4` (`product_category_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blogs`
--
ALTER TABLE `blogs`
  MODIFY `blog_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `coupons`
--
ALTER TABLE `coupons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `coupon_conditions`
--
ALTER TABLE `coupon_conditions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `order_detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `FK150sonee311u9q6yoee6onyyf` FOREIGN KEY (`user_user_name`) REFERENCES `users` (`user_name`),
  ADD CONSTRAINT `FKjvtescr8p5gnfwauss1f9s61t` FOREIGN KEY (`product_product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `coupon_conditions`
--
ALTER TABLE `coupon_conditions`
  ADD CONSTRAINT `FKhqpecssefaknbbcmd78wrrnal` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKinlq3l5oq62ubxyn5dt74bn1q` FOREIGN KEY (`user_user_name`) REFERENCES `users` (`user_name`),
  ADD CONSTRAINT `FKn1d1gkxckw648m2n2d5gx0yx5` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKp7dy0okc2p35dj70wl4grqlw4` FOREIGN KEY (`product_category_id`) REFERENCES `categories` (`category_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_name`),
  ADD CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
