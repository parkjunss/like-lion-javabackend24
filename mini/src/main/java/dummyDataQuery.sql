DROP TABLE IF EXISTS users, products, orders;

create table users(
	id bigint primary key not null auto_increment,
    username varchar(100) unique not null,
    password varchar(255) not null,
    balance decimal(15,2) default 0.00,
	created_at datetime default current_timestamp
);

create table products (
	id bigint(200) primary key not null auto_increment,
    title varchar(100) not null default '제목없음',
    content text,
    price decimal(15,2) default 0.00 not null,
    stock_quantity int not null default 0,
    user_id bigint,
	created_at datetime default current_timestamp,
    foreign key(user_id) references users(id)
);

create table orders(
	id bigint primary key not null auto_increment,
    user_id bigint not null,
    product_id bigint not null,
    order_price decimal(15,2) not null,
	created_at datetime default current_timestamp,
    foreign key(user_id) references users(id),
    foreign key(product_id) references products(id)
);



INSERT INTO users (username, password, balance) VALUES
('kim_java', 'password123', 100000.00),
('lee_spring', 'pass456', 5000.00),
('choi_web', 'pass04', 10000.00),
('jung_data', 'pass05', 0.00),
('kang_dev', 'pass06', 300000.00),
('yoon_cloud', 'pass07', 45000.00),
('jang_git', 'pass08', 12000.00),
('lim_docker', 'pass09', 88000.00),
('han_linux', 'pass10', 500.00),
('park_db', 'admin789', 0.00);

INSERT INTO products (title, content, price, stock_quantity, user_id) VALUES
('맛있는 사과', '청송에서 갓 따온 사과입니다.', 1500.00, 50, 1),
('기계식 키보드', '타건감이 좋은 갈축 키보드', 85000.00, 5, 1),
('Java 프로그래밍 입문', '데이터베이스 연동 실습책', 25000.00, 10, 2),
('무선 마우스', '그립감이 좋은 무소음 마우스', 25000.00, 30, 1),
('기계식 키보드', '청축의 찰진 타건감', 89000.00, 5, 1),
('27인치 모니터', '4K 해상도 지원 업무용 모니터', 350000.00, 10, 3),
('Java 완벽 가이드', '신입 개발자 필독서', 33000.00, 100, 2),
('USB-C 허브', '7 in 1 멀티 허브', 42000.00, 0, 4),
('노트북 거치대', '알루미늄 접이식 거치대', 19000.00, 15, 6),
('개발자용 장패드', '가로 90cm 넓은 패드', 12000.00, 50, 7),
('웹캠 1080p', '화상 회의용 고화질 웹캠', 55000.00, 3, 9),
('코딩용 안경', '블루라이트 차단 안경', 28000.00, 20, 1),
('친환경 텀블러', '스테인리스 500ml 텀블러', 15000.00, 40, 5);


-- 1. 안전 모드 해제
SET SQL_SAFE_UPDATES = 0;

-- 2. 비밀번호 암호화 실행
UPDATE users SET password = SHA2(password, 256);

-- 3. 안전 모드 다시 설정 (권장)
SET SQL_SAFE_UPDATES = 1;

select * from users;
select * from products;
select * from orders;


