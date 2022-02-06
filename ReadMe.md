#Garaj Uygulaması
Bu uygulamada Car,Jeep,Truck sınıfları ve özellikleri Vehicle abstract sınıftan
extend edilmiş sadece herbirinde toString metdoları override edilmiştir.

toString metodunun override işleminde her değişiklikte hafızada yeni yer açılmaması için
StringBuilder kullanılmıştır.

Ticket sınıfında field olarak vehicle ve ticketNumber tanımlanmış olup
bilet numarası UUID ile benzersiz sekilde verilmesi saglanmıştır.

Herbir aracın plaka,renk ve tuttugu yer field olarak vehicle abstract 
sınıfta tanımlanmıştır.

Nesne üretimi için Factory Design Pattern Kullanılmıştır sebebi her bir sınıf için tek tek 
nesne üretimi degilde VehicleFactory den araç tipine göre nesne üretilip döndürülmesini
sağlamaktır.Burada nesnelerin tutacagı yer de belirlenip üretim yapılmaktadır.

GarageService Interface inde gerekli metodlar yazılmış olup GarageServiceImpl
sınıfında bu interfaceden implement işlemi yapılmıştır. Impl sınıfında park eden araç
listesi,park başlatma,bitirme, garaj durumu gibi metodlar yazılmıştır.

ParkingDto sınıfında bize clienttan gelecek isteklerin hangi formatta olaması gerektiği
belirlenmiştir.

Controller katmanında ise gerekli işlemler için GarageService interface i kullanılarak
gelen isteklere nasıl işlemler yapılacağı yazılmıştır.

Hata yapıları için ErrorDto yapısı kurulup , exception package ı içinde uygulamamıza özel
exception GarageApiException oluşturulmuştur. Global exception sınıfında ise gelen hatanın türüne göre 
response entitiy de nasıl görüneceği belirlenmiştir. Postman da deneme yapılarak geçersiz bilet ve park
yeri kalmaması cevapları json ve hata kodu ile görülebilir.

PostDto da Starter validation kullanılarak kullacını boş ya da minimum karakterden az giriş yaparak istek göndermesi
engellenmiştir.
