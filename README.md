# Baby Name Statistics Analyzer

Bu proje, kullanıcıların belirli bir yıl için popüler bebek isimlerinin sıralandığı bir dosyayı yükleyerek, isimlerin popülerlik sırasını, sayılarını ve yüzdelerini görüntülemelerini sağlar. Proje, kullanıcı dostu bir şekilde verileri analiz etmeye olanak tanır.

## Kullanılan Teknolojiler

- **Java**: Uygulamanın temel dili.
- **CSV Dosyası**: Bebek isimlerinin ve sayıların bulunduğu veri dosyası.
- **ArrayList**: Popüler isimlerin saklandığı veri yapısı.

## Özellikler

- **Veri Yükleme**: Kullanıcı, belirli bir CSV dosyasını yükler. Dosya içindeki erkek ve kız isimleri ile ilgili veriler okunur ve ilgili listelere eklenir.
- **Sıralama**: Erkek ve kız isimleri alfabetik sıraya göre sıralanır.
- **İsim Arama**: Kullanıcı, belirli bir isim arayarak, o ismin sırasını, popülerliğini, ve bebek sayısını öğrenebilir.
- **Yüzde Hesaplama**: Kullanıcı, girilen ismin bebeklerin toplam sayısına oranla ne kadar bir yüzdesini oluşturduğunu görebilir.

## Sınıflar

### 1. **Main.java**
   Uygulamanın başlangıç noktasıdır. Kullanıcıdan dosya adı alınır, veri okunur, sıralama yapılır ve kullanıcıya etkileşimli arama yapma imkanı sunulur.

### 2. **PopularName.java**
   Popüler isimleri temsil eden bir sınıftır. İsim, sıralama numarası ve toplam bebek sayısını içerir.

### 3. **Util.java**
   Popüler isimlerin listesini işlemek için çeşitli yardımcı metotlar içerir:
   - `selectionSortByName()`: İsimleri alfabetik sıraya göre sıralar.
   - `getTotalBabiesByGender()`: Belirli bir cinsiyetin toplam bebek sayısını döndürür.
   - `findIndexByName()`: Verilen bir ismin dizideki indeksini bulur.