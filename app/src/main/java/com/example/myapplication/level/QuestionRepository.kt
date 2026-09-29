package com.example.myapplication.level

import com.example.myapplication.kuis.QuestionModel

object QuestionRepository {
    fun getQuestions(levelId: Int): List<QuestionModel> {
        return when (levelId) {
            1 -> listOf(
                QuestionModel(
                    "Berapa jumlah sila dalam Pancasila?",
                    listOf("Lima", "Empat", "Tiga", "Enam"),
                    "Lima",
                    "Jumlah sila dari Pancasila adalah 5. Sila 1 yaitu 'Ketuhanan Yang Maha Esa', Sila 2 yaitu 'Kemanusiaan yang adil dan beradab', Sila 3 yaitu 'Persatuan Indonesia', Sila 4 yaitu 'Kerakyatan yang dipimpin oleh hikmat kebijaksanaan dalam permusyawaratan perwakilan', Sila 5 yaitu 'Keadilan sosial bagi seluruh rakyat Indonesia'."
                ),
                QuestionModel(
                    "Anak yang melanggar aturan berhak mendapatkan ...",
                    listOf("Pujian", "Penghargaan", "Sanksi", "Hadiah"),
                    "Sanksi",
                    "Sanksi merupakan hukuman yang diberikan jika seseorang melanggar peraturan yang ada. Sanksi biasanya untuk memberikan efek jera pada orang yang telah melanggar peraturan."
                ),
                QuestionModel(
                    "Contoh perilaku yang sesuai dengan sila pertama adalah….",
                    listOf("Membantu kakak menyapu", "Bermusyawarah dengan teman sekelas", "Menolong teman yang kesusahan", "Berdoa sebelum makan"),
                    "Berdoa sebelum makan",
                    "Sila pertama Pancasila adalah 'Ketuhanan Yang Maha Esa'. Berdoa sebelum makan mencerminkan pengakuan akan adanya Tuhan Yang Maha Esa dan rasa syukur atas nikmat-nikmat yang diberikan-Nya. Dalam banyak budaya dan agama, berdoa sebelum makan merupakan ungkapan rasa terima kasih kepada Tuhan atas rezeki yang diberikan, sehingga perilaku ini sesuai dengan nilai-nilai dalam sila pertama Pancasila."
                ),
                QuestionModel(
                    "Bila guru sedang menjelaskan materi di depan kelas, kita sebaiknya ...",
                    listOf("Berbicara", "Memperhatikan", "Membuat gaduh", "Mengabaikan"),
                    "Memperhatikan",
                    "Saat guru menjelaskan di depan kelas, siswa wajib memberikan perhatian dengan cara mendengarkan penjelasan guru. Hal ini merupakan contoh sikap menghargai orang lain, selain itu dengan memperhatikan guru dapat menerima ilmu yang diberikan melalui penjelasan."
                ),
                QuestionModel(
                    "Toni kesulitan mengerjakan PR Matematika. Sikap kamu sebaiknya...",
                    listOf("Membantu", "Mengejek", "Membiarkannya agar gagal mengerjakan PR", "Menyuruhnya mencari jawaban di internet"),
                    "Membantu",
                    "Ketika menemukan teman atau seseorang yang mengalami kesulitan, sebaiknya kita memberikan pertolongan."
                ),
                QuestionModel(
                    "Sila keempat dalam Pancasila mengajarkan kita untuk selalu menjunjung ...",
                    listOf("Kekeluargaan dan gotong royong", "Permusuhan dan kebencian", "Saling curiga dan kemalasan", "Kemandirian dan individualisme"),
                    "Kekeluargaan dan gotong royong",
                    "Bunyi sila keempat adalah 'kerakyatan yang dipimpin oleh hikmah kebijaksanaan dalam permusyawaratan perwakilan'. Dari bunyi sila tersebut dapat disimpulkan bahwa perilaku yang sesuai adalah kekeluargaan dan gotong-royong. Sikap permusuhan, kebencian, saling curiga, dan kemalasan tidak mencerminkan pengajaran dari sila keempat."
                ),
                QuestionModel(
                    "Aku berwarna merah dan putih. Aku selalu dikibarkan pada saat upacara di hari Senin atau di hari-hari tertentu. Siapakah aku?",
                    listOf("Bendera Indonesia", "Pancasila", "Bhineka Tunggal Ika", "Burung Garuda"),
                    "Bendera Indonesia",
                    "Bendera Indonesia adalah bendera nasional yang terdiri dari warna merah di bagian atas dan putih di bagian bawahnya. Merah melambangkan keberanian dan semangat, sementara putih melambangkan kesucian dan kedamaian. Bendera ini selalu dikibarkan pada saat upacara kenegaraan, acara resmi, atau perayaan hari-hari penting seperti Hari Kemerdekaan Indonesia pada tanggal 17 Agustus. Bendera Indonesia merupakan simbol dari Negara Kesatuan Republik Indonesia yang merdeka dan bersatu."
                ),
                QuestionModel(
                    "Lisa bertemu dengan teman baru di sekolah. Sebaiknya sikap yang Lisa lakukan adalah…",
                    listOf("Memusuhinya", "Memarahinya", "Diam saja", "Mengajak berkenalan"),
                    "Mengajak berkenalan",
                    "Lisa sebaiknya mengajak teman barunya berkenalan. Ini artinya, Lisa bisa menyapa temannya dengan ramah dan bertanya namanya. Mungkin juga bisa bertanya apa yang disukai temannya dan menawarkan untuk bermain bersama. Yang penting adalah Lisa menunjukkan sikap baik dan ramah kepada teman barunya. Mengajak teman baru berkenalan akan membantu membangun hubungan yang baik antara mereka dan menciptakan lingkungan sekolah yang ramah dan mendukung."
                ),
                QuestionModel(
                    "Menjaga kebersihan rumah merupakan kewajiban…",
                    listOf("Ibu", "Ayah", "Nenek", "Semua anggota keluarga"),
                    "Semua anggota keluarga",
                    "Menjaga kebersihan rumah merupakan tanggung jawab bersama dari semua anggota keluarga. Setiap anggota keluarga, baik ibu, ayah, anak-anak, maupun anggota keluarga lainnya, memiliki peran dalam menjaga kebersihan rumah agar tetap bersih, nyaman, dan sehat untuk ditinggali bersama."
                ),
                QuestionModel(
                    "Jika ada orang yang menanyakan namamu, maka kamu harus…",
                    listOf("Menjawab dengan menunduk", "Diam saja dan tidak peduli", "Menjawab dengan nada tinggi", "Menyebutkan nama dengan sopan"),
                    "Menyebutkan nama dengan sopan",
                    "Ketika seseorang bertanya, 'Siapa namamu?' kamu harus menjawab dengan baik dan sopan dengan menyebutkan nama kamu. Ini adalah cara yang baik untuk berbicara dengan orang lain."
                )
            )

            4 -> listOf(
                QuestionModel(
                    "Salah satu cara mewujudkan persatuan adalah menjaga kerukunan. Berikut ini kegiatan yang mencerminkan kerukunan di sekolah adalah ….",
                    listOf("Tidak mengejek teman jika ada guru di dalam kelas", "Membentuk kelompok belajar khusus untuk anak yang pandai", "Saling menolong pada waktu piket membersihkan kelas", "Memberikan jawaban kepada teman saat ujian"),
                    "Saling menolong pada waktu piket membersihkan kelas",
                    "Kerukunan berarti sepakat dalam perbedaan-perbedaan yang ada dan menjadikan perbedaan itu sebagai titik tolak untuk membina kehidupan sosial yang saling pengertian serta menerima dengan ketulusan hati yang penuh keikhlasan."
                ),
                QuestionModel(
                    "Kepala banteng adalah simbol sila ke … Pancasila",
                    listOf("Satu", "Dua", "Tiga", "Empat"),
                    "Empat",
                    "Kepala banteng adalah simbol dari Sila ke-4 Pancasila, yaitu 'Kerakyatan yang Dipimpin oleh Hikmat Kebijaksanaan dalam Permusyawaratan/Perwakilan'. Simbol ini menggambarkan semangat demokrasi, di mana kebijaksanaan dan keputusan diambil melalui proses musyawarah untuk mencapai mufakat, sehingga mewujudkan kedaulatan rakyat."
                ),
                QuestionModel(
                    "Bunyi sila pada simbol pohon beringin adalah…",
                    listOf("Ketuhanan Yang Maha Esa", "Keadilan Sosial Bagi Seluruh Rakyat Indonesia", "Kemanusiaan Yang Adil dan Beradab", "Persatuan Indonesia"),
                    "Persatuan Indonesia",
                    "Pancasila itu adalah dasar negara kita Indonesia. Pancasila punya lima sila yang penting. Nah, salah satu silanya adalah persatuan. Persatuan artinya kita semua bersama-sama, tidak terpecah-belah. Nah, pohon beringin adalah gambaran dari persatuan. Seperti pohon beringin yang daun-daunnya bercabang-cabang, tapi tetap bersatu di dalam satu pohon. Jadi, ketika kita melihat gambar pohon beringin, itu mengingatkan kita untuk selalu bersatu dan saling mendukung di Indonesia kita yang besar ini."
                ),
                QuestionModel(
                    "Dino adalah anak yang suka berbagi dan bersikap adil. Sikap Dino termasuk ke dalam Pancasila sila ke…",
                    listOf("5", "4", "2", "1"),
                    "5",
                    "Di dalam Pancasila, ada yang namanya 'Keadilan Sosial Bagi Seluruh Rakyat Indonesia'. Itu artinya, kita harus memperlakukan semua orang dengan adil dan memberikan kesempatan yang sama kepada semua orang. Jadi, sikap Dino yang suka berbagi dan bersikap adil itu sesuai dengan Pancasila sila ke-5, yaitu Keadilan Sosial Bagi Seluruh Rakyat Indonesia."
                ),
                QuestionModel(
                    "Lambang Negara Indonesia adalah ....",
                    listOf("Garuda Pancasila", "UUD 1945", "Bendera Merah Putih", "Padi dan Kapas"),
                    "Garuda Pancasila",
                    "Lambang negara Indonesia adalah Lambang Garuda Pancasila. Lambang ini menggambarkan semangat dan kepribadian bangsa Indonesia serta mewakili nilai-nilai Pancasila sebagai dasar negara. Lambang Garuda Pancasila terdiri dari burung Garuda yang menggenggam pancang dengan sembilan bulu ekor dan 17 bulu sayap yang melambangkan tanggal proklamasi kemerdekaan Indonesia, yaitu 17 Agustus 1945."
                ),
                QuestionModel(
                    "Lala selalu bersyukur terhadap Tuhan Yang Maha Esa atas anugerah yang diberikan. Sikap Lala sesuai dengan Pancasila sila ke…",
                    listOf("2", "1", "4", "5"),
                    "1",
                    "Sikap Lala yang selalu bersyukur terhadap Tuhan Yang Maha Esa atas anugerah yang diberikan sesuai dengan Sila pertama Pancasila, yaitu 'Ketuhanan Yang Maha Esa'. Sila ini mengajarkan pentingnya keyakinan akan adanya Tuhan yang Maha Esa dalam kehidupan. Dengan bersyukur kepada Tuhan, Lala menunjukkan penghormatan terhadap nilai-nilai spiritual dan kepercayaan yang mendasari kehidupan."
                ),
                QuestionModel(
                    "Berikut yang merupakan contoh aturan dalam lingkungan sekolah adalah….",
                    listOf("Mengucapkan salam setiap masuk ke dalam rumah", "Setiap siswa tidak boleh bertengkar dengan temannya", "Setiap bangun tidur harus merapikan tempat tidur", "Bangun pukul 05.00 pagi"),
                    "Setiap siswa tidak boleh bertengkar dengan temannya",
                    "Pernyataan yang menunjukkan contoh aturan dalam lingkungan sekolah adalah opsi B yaitu setiap siswa tidak boleh bertengkar dengan temannya yang menunjukkan sikap rukun dengan teman di sekolah."
                ),
                QuestionModel(
                    "Perhatikan pernyataan berikut ini!\n1. Anita selalu membantu ibu di rumah\n2. Angga selalu datang terlambat\n3. Rian rajin belajar di malam hari\n4. Tina bermain hingga lupa hari\nBerdasarkan pernyataan di atas, perilaku yang sesuai dengan aturan di rumah ditunjukkan oleh nomor….",
                    listOf("1) dan 2)", "2) dan 4)", "1) dan 3)", "1) dan 4)"),
                    "1) dan 3)",
                    "Pada pernyataan di atas yang menunjukkan perilaku yang sesuai dengan aturan di rumah yaitu pada nomor 1 dan 3."
                ),
                // Additional questions
                QuestionModel(
                    "Apa yang dimaksud dengan sila Kemanusiaan yang Adil dan Beradab dalam Pancasila?",
                    listOf("Keadilan bagi seluruh rakyat Indonesia", "Persatuan yang tidak tergoyahkan", "Pengakuan atas hak asasi manusia dan perlakuan yang adil", "Ketuhanan Yang Maha Esa"),
                    "Pengakuan atas hak asasi manusia dan perlakuan yang adil",
                    "Sila Kemanusiaan yang Adil dan Beradab dalam Pancasila menekankan pentingnya pengakuan dan penghormatan terhadap hak asasi manusia serta perlakuan yang adil terhadap setiap individu. Sila ini mengajarkan kita untuk memperlakukan orang lain dengan hormat dan adil, tanpa memandang perbedaan suku, agama, atau latar belakang lainnya."
                ),
                QuestionModel(
                    "Simbol apa yang terdapat pada Pancasila yang menggambarkan sila Keadilan Sosial Bagi Seluruh Rakyat Indonesia?",
                    listOf("Pohon Beringin", "Kepala Banteng", "Burung Garuda", "Padi dan Kapas"),
                    "Padi dan Kapas",
                    "Simbol Padi dan Kapas pada Pancasila menggambarkan sila ke-5 yaitu Keadilan Sosial Bagi Seluruh Rakyat Indonesia. Simbol ini melambangkan kesejahteraan sosial yang merata dan kesetaraan bagi seluruh rakyat Indonesia. Padi melambangkan kesejahteraan, sedangkan kapas melambangkan keadilan sosial."
                )
            )


//            3 -> listOf(
//                QuestionModel("", "Ir. Soekarno", "Ir. Soekarno adalah Presiden pertama Republik Indonesia, menjabat dari tahun 1945 hingga 1967.")
//            )
            2 -> listOf(
                QuestionModel(
                    "Indonesia terdiri dari berbagai suku bangsa dengan adat dan kebiasaan yang berbeda. Perbedaan Indonesia memiliki semboyan “Bhinneka Tunggal Ika”. Di bawah ini lambang semboyan Negara Indonesia yang benar adalah….",
                    listOf("Burung Garuda", "Kepala Banteng", "Burung Rajawali", "Burung Merak"),
                    "Burung Garuda",
                    "Bhinneka Tunggal Ika menjadi semboyan negara Indonesia. Semboyan ini menggambarkan persatuan dan kesatuan bangsa Indonesia yang terdiri dari berbagai suku, agama, ras dan budaya. Arti dari Bhinneka Tunggal Ika ialah berbeda-beda tetapi tetap satu jua. Sudah seharusnya prinsip Bhinneka Tunggal Ika senantiasa diterapkan dalam kehidupan sehari-hari. Karena dengan menerapkannya, persatuan dan kesatuan Bangsa Indonesia tetaplah terjaga."
                ),
                QuestionModel(
                    "Apa yang dimaksud dengan sila Ketuhanan Yang Maha Esa dalam Pancasila?",
                    listOf("Keadilan sosial bagi seluruh rakyat Indonesia", "Persatuan Indonesia", "Kepercayaan kepada Tuhan Yang Maha Esa", "Kemanusiaan Yang Adil Dan Beradab"),
                    "Kepercayaan kepada Tuhan Yang Maha Esa",
                    "Sila pertama Pancasila mengajarkan warga negara Indonesia untuk memiliki kepercayaan kepada Tuhan Yang Maha Esa sesuai dengan kepercayaan masing-masing."
                ),
                QuestionModel(
                    "Perhatikan pernyataan di bawah ini!\n1. Bersatu kita teguh bercerai kita runtuh\n2. Berbeda-beda tetapi tetap bermusuhan\n3. Berbeda-beda tetapi mengharumkan\n4. Berbeda-beda tetapi tetap satu jua\nBerdasarkan pernyataan di atas, arti dari “Bhinneka Tunggal Ika” ditunjukkan oleh nomor….",
                    listOf("2)", "3)", "1)", "4)"),
                    "4)",
                    "Susunan yang benar mengenai arti Bhinneka Tunggal Ika adalah Berbeda-beda tetapi tetap satu jua."
                ),
                QuestionModel(
                    "Hak setiap murid di sekolah harus ...",
                    listOf("Diberikan", "Dibiarkan", "Diabaikan","Dihilangkan"),
                    "Diberikan",
                    "Setiap hak seseorang harus dihargai dan diberikan. Biasanya pemberian hak sejalan dengan kewajiban yang telah dilaksanakan."
                ),
                QuestionModel(
                    "Norma yang mengatur hubungan antara individu di dalam masyarakat disebut dengan norma...",
                    listOf("Hukum", "Sosial", "Moral", "Agama"),
                    "Sosial",
                    "Norma sosial adalah norma yang mengatur hubungan antara individu dalam masyarakat. Norma ini membentuk dasar bagaimana orang berinteraksi, bersosialisasi, dan beradaptasi dalam lingkungan sosial mereka."
                ),
                QuestionModel(
                    "Berikut yang merupakan salah satu contoh dari norma agama adalah...",
                    listOf("Menghormati orang tua", "Tidak melanggar rambu lalulintas", "Larangan berzina", "Semua jawaban benar"),
                    "Larangan berzina",
                    "Norma agama adalah norma yang bersumber dari ajaran agama. Beberapa contoh norma agama adalah: Larangan mencuri, Larangan membunuh, Larangan berzina, Menghormati agama orang lain, dan lain-lain."
                ),
                QuestionModel(
                    "Berikut yang merupakan salah satu fungsi norma dalam kehidupan bermasyarakat, kecuali...",
                    listOf("Mengatur perilaku individu", "Menciptakan ketertiban", "Menjamin kebahagiaan masyarakat", "Menjaga stabilitas sosial"),
                    "Menjamin kebahagiaan masyarakat",
                    "Norma dalam kehidupan bermasyarakat memiliki beberapa fungsi, yaitu: Mengatur perilaku individu, agar perilaku individu sesuai dengan nilai-nilai yang berlaku di masyarakat. Menciptakan ketertiban, dengan adanya norma maka akan tercipta ketertiban dalam masyarakat. Menjaga stabilitas sosial, dengan adanya norma maka akan tercipta stabilitas sosial dalam masyarakat."
                ),
                QuestionModel(
                    "Norma yang mengatur hubungan antara individu dengan masyarakat disebut juga dengan norma...",
                    listOf("Norma agama", "Norma hukum", "Norma kesusilaan", "Norma sopan santun"),
                    "Norma kesusilaan",
                    "Norma kesusilaan adalah norma yang mengatur hubungan antara individu dengan masyarakat. Norma ini berkaitan dengan nilai-nilai moral dan etika yang berlaku di dalam masyarakat. Norma kesusilaan berfungsi untuk mengatur perilaku individu agar sesuai dengan nilai-nilai yang dianggap baik dan benar oleh masyarakat."
                ),
                QuestionModel(
                    "Berikut ini tindakan yang menunjukkan sikap menjaga keutuhan Indonesia yaitu….",
                    listOf("Memusuhi umat agama lain", "Membabat hutan dengan semena-mena", "Menghormati teman yang berbeda suku", "Membuat kerusuhan pada hari besar agama lain"),
                    "Menghormati teman yang berbeda suku",
                    "Perbedaan yang ada akan menjadi indah jika terjadi kerukunan, bahkan menjadi sebuah kebanggaan karena merupakan salah satu kekayaan bangsa."
                ),
                QuestionModel(
                    "Tanggung jawab setiap warga negara adalah …. ",
                    listOf("Menjaga persatuan dan kesatuan bangsa dengan menghindari sikap dan perilaku yang diskriminatif", "Mempunyai kebebasan memeluk dan menjalankan agama yang mereka percayai", "Memiliki kedudukan yang sama di mata hukum", "Menyuarakan pendapat mereka"),
                    "Menjaga persatuan dan kesatuan bangsa dengan menghindari sikap dan perilaku yang diskriminatif",
                    "Opsi B termasuk ke dalam hak setiap warga negara dan termasuk sebagai hak asasi. Opsi C termasuk dalam hak konstitusional setiap warga negara. Opsi D termasuk bagian dari hak dasar setiap manusia."
                )

            )

            5 -> listOf(
                QuestionModel(
                    "Dalam pasal 28 UUD 1945, organisasi disebut juga dengan istilah…",
                    listOf("Berserikat", "Bertukar pikiran", "Berkelompok", "Bekerja sama"),
                    "Berserikat",
                    "Pasal 28 UUD 1945 menyatakan bahwa setiap orang berhak untuk berserikat, berasosiasi, dan berkumpul secara damai."
                ),
                QuestionModel(
                    "Tanggung jawab setiap warga negara adalah ….",
                    listOf("Menjaga persatuan dan kesatuan bangsa dengan menghindari sikap dan perilaku yang diskriminatif", "Mempunyai kebebasan memeluk dan menjalankan agama yang mereka percayai", "Memiliki kedudukan yang sama di mata hukum", "Menyuarakan pendapat mereka"),
                    "Menjaga persatuan dan kesatuan bangsa dengan menghindari sikap dan perilaku yang diskriminatif",
                    "Opsi B termasuk ke dalam hak setiap warga negara dan termasuk sebagai hak asasi. Opsi C termasuk dalam hak konstitusional setiap warga negara. Opsi D termasuk bagian dari hak dasar setiap manusia."
                ),
                QuestionModel(
                    "Bacalah teks berikut dengan saksama!\n\nRumah Sonia dan Maruna berhadapan. Mereka berdua memiliki keyakinan yang berbeda. Suatu hari keluarga Maruna sedang kerja bakti membersihkan lingkungan rumahnya, karena sebentar lagi akan ada tamu dalam rangka merayakan Natal. Sikap Sonia sebaiknya….",
                    listOf("ikut kerja bakti membersihkan lingkungan sekitar rumah", "meminta Maruna membersihkan sekitar rumahnya", "pura-pura tidak tahu dan diam menonton TV", "pergi bermain dengan teman lainnya"),
                    "ikut kerja bakti membersihkan lingkungan sekitar rumah",
                    "Gotong royong yang mengandung sikap persatuan merupakan salah satu contoh bentuk kehidupan yang memiliki nilai-nilai luhur sila ketiga Pancasila yang mengarah pada persatuan."
                ),
                QuestionModel(
                    "Supaya kita dapat hidup aman dan tenteram dalam kehidupan masyarakat yang harus dihindari adalah sikap …. ",
                    listOf("mencampuri urusan orang lain", "terbuka kepada masyarakat", "menjunjung tinggi nilai kemanusiaan", "hormat-menghormati antarsesama"),
                    "mencampuri urusan orang lain",
                    "Mencampuri urusan orang lain dapat menjadi sumber konflik dan ketegangan dalam masyarakat."
                ),
                QuestionModel(
                    "Kegiatan gotong-royong dapat menumbuhkan semangat ....",
                    listOf("Perpecahan", "Persatuan", "Permusuhan", "Perselisihan"),
                    "Persatuan",
                    "Gotong-royong merupakan kegiatan yang melibatkan partisipasi aktif dari banyak orang dalam melakukan suatu pekerjaan secara bersama-sama demi kepentingan bersama. Melalui gotong-royong, orang-orang belajar bekerja bersama, saling membantu, dan saling mendukung. Ini menciptakan ikatan persatuan di antara mereka, karena mereka bekerja bersama-sama untuk mencapai tujuan yang sama."
                ),
                QuestionModel(
                    "Contoh perilaku yang sesuai dengan sila pertama adalah….",
                    listOf("Membantu kakak menyapu", "Bermusyawarah dengan teman sekelas", "Menolong teman yang kesusahan", "Berdoa sebelum makan"),
                    "Berdoa sebelum makan",
                    "Sila pertama Pancasila adalah 'Ketuhanan Yang Maha Esa'. Berdoa sebelum makan mencerminkan pengakuan akan adanya Tuhan Yang Maha Esa dan rasa syukur atas nikmat-nikmat yang diberikan-Nya. Dalam banyak budaya dan agama, berdoa sebelum makan merupakan ungkapan rasa terima kasih kepada Tuhan atas rezeki yang diberikan, sehingga perilaku ini sesuai dengan nilai-nilai dalam sila pertama Pancasila."
                ),
                QuestionModel(
                    "Setiap siswa harus menjaga sarana pendidikan yang ada di sekolah dengan baik. Ketika sarana tidak dijaga dengan baik maka sarana belajarnya akan rusak sehingga kegiatan belajar akan terganggu. Supaya kegiatan belajar berjalan dengan baik maka siswa harus menjalankan …. Sebagai siswa dengan penuh tanggung jawab.",
                    listOf("Kewajiban", "Hak", "Sikap", "Norma"),
                    "Kewajiban",
                    "Secara umum, kewajiban adalah sebuah tindakan yang harus dikerjakan seseorang. Dari pernyataan di atas terdapat kata kunci harus maka jawaban yang benar adalah opsi A."
                ),
                QuestionModel(
                    "Tanggung jawab setiap warga negara adalah …. ",
                    listOf("Menjaga persatuan dan kesatuan bangsa dengan menghindari sikap dan perilaku yang diskriminatif", "Mempunyai kebebasan memeluk dan menjalankan agama yang mereka percayai", "Memiliki kedudukan yang sama di mata hukum", "Menyuarakan pendapat mereka"),
                    "Menjaga persatuan dan kesatuan bangsa dengan menghindari sikap dan perilaku yang diskriminatif",
                    "Opsi B termasuk ke dalam hak setiap warga negara dan termasuk sebagai hak asasi. Opsi C termasuk dalam hak konstitusional setiap warga negara. Opsi D termasuk bagian dari hak dasar setiap manusia."
                ),
                QuestionModel(
                    "Proses penunjukan pengurus organisasi dengan cara ditunjuk langsung oleh seluruh anggota organisasi disebut …. ",
                    listOf("Interpelasi", "Demokrasi", "Aklamasi", "Instruksi"),
                    "Aklamasi",
                    "Menurut Kamus Besar Bahasa Indonesia (KBBI) Aklamasi didefinisikan sebagai pernyataan setuju secara lisan dari seluruh peserta rapat terhadap suatu usul tanpa melalui pemungutan suara."
                ),
                QuestionModel(
                    "Kristin beragama Katolik sedang Mahmud beragama Islam. Ketika itu hari Minggu. Saat sedang menyelesaikan tugas kelompok, hari sudah menjelang sore. Kristin meminta izin melaksanakan ibadah di gereja. Sikap yang baik dilakukan Ahmad adalah ….",
                    listOf("Melarang Kristin karena tugas belum selesai.", "Meminta Kristin menunda ibadahnya pekan depan.", "Mempersilahkan Kristin pergi beribadah ke gereja.", "Bersama Ahmad mengerjakan pergi ke gereja."),
                    "Mempersilahkan Kristin pergi beribadah ke gereja.",
                    "Pada sila pertama Pancasila yaitu Ketuhanan Yang Maha Esa mengandung nilai-nilai dimana seluruh warga Indonesia dapat memeluk agama masing-masing dan beribadah menurut agamanya. Oleh karena itu, sebagai warga negara kita sudah seharusnya saling menghargai teman yang berbeda agama dan mempersilahkannya untuk beribadah sesuai keyakinannya."
                )
            )

            7 -> listOf(
                QuestionModel(
                    "Pancasila adalah fondasi sekaligus pedoman dalam penyelenggaraan negara Indonesia. Dengan demikian Pancasila berfungsi sebagai ....",
                    listOf("Dasar negara", "Ideologi negara", "Pandangan hidup bangsa", "Cita-cita nasional"),
                    "Dasar negara",
                    "Pancasila digunakan sebagai dasar oleh negara dalam mengatur pemerintahan dan penyelenggaraan negara. Selain itu, arti Pancasila sebagai dasar negara juga dapat dimaknai dengan dijadikannya Pancasila sebagai pedoman dan prinsip dasar dalam kehidupan."
                ),
                QuestionModel(
                    "Pancasila adalah fondasi sekaligus pedoman dalam penyelenggaraan negara Indonesia. Dengan demikian Pancasila berfungsi sebagai ....",
                    listOf("Dasar negara", "Ideologi negara", "Pandangan hidup bangsa", "Cita-cita nasional"),
                    "Dasar negara",
                    "Pancasila digunakan sebagai dasar oleh negara dalam mengatur pemerintahan dan penyelenggaraan negara. Selain itu, arti Pancasila sebagai dasar negara juga dapat dimaknai dengan dijadikannya Pancasila sebagai pedoman dan prinsip dasar dalam kehidupan."
                ),
                QuestionModel(
                    "Ketika sedang belajar kelompok ada dua teman yang berselisih, sikap Rizal sebagai ketua kelompok adalah …. ",
                    listOf("Condong pada salah satu pihak dan menyalahkan yang lain.", "Diam saja, biarkan, karena nanti damai dengan sendirinya.", "Mendamaikan supaya keutuhan kelompok terjaga.", "Memberi sanksi pada teman yang salah."),
                    "Mendamaikan supaya keutuhan kelompok terjaga.",
                    "Salah satu sikap yang harus dimiliki oleh seorang pemimpin adalah sikap tanggung jawab. Sebagai ketua kelompok Rizal bertanggung jawab dalam menjaga keutuhan kelompoknya."
                ),
                QuestionModel(
                    "Salah satu cara mewujudkan persatuan adalah menjaga kerukunan. Berikut ini kegiatan yang mencerminkan kerukunan di sekolah adalah …. ",
                    listOf("Tidak mengejek teman jika ada guru di dalam kelas.", "Membentuk kelompok belajar khusus untuk anak yang pandai.", "Saling menolong pada waktu piket membersihkan kelas.", "Memberikan jawaban kepada teman saat ujian."),
                    "Saling menolong pada waktu piket membersihkan kelas.",
                    "Kerukunan berarti sepakat dalam perbedaan-perbedaan yang ada dan menjadikan perbedaan itu sebagai titik tolak untuk membina kehidupan sosial yang saling pengertian serta menerima dengan ketulusan hati yang penuh keikhlasan."
                ),
                QuestionModel(
                    "Apa yang dimaksud dengan 'identitas diri'?",
                    listOf("Identitas diri adalah tentang berapa banyak teman kita", "Identitas diri adalah tentang siapa kita dan bagaimana kita berbeda dari orang lain", "Identitas diri adalah tentang berapa banyak mainan yang kita miliki", "Identitas diri adalah tentang baik buruknya seseorang"),
                    "Identitas diri adalah tentang siapa kita dan bagaimana kita berbeda dari orang lain",
                    "Identitas diri adalah tentang siapa kita dan bagaimana kita berbeda dari orang lain. Ini berarti itu adalah cara kita melihat dan memahami diri kita sendiri, serta apa yang membuat kita unik dibandingkan dengan orang lain di sekitar kita. Identitas diri mencakup hal-hal seperti nama, keluarga, teman, minat, dan hal-hal lain yang membuat kita menjadi diri kita sendiri."
                ),
                QuestionModel(
                    "Bagaimana cara kita menyebutkan identitas nonfisik teman di sekolah?",
                    listOf("Dengan menyebutkan nama dan warna baju mereka", "Dengan menyebutkan nama dan sifat-sifat positif mereka", "Dengan menyebutkan nama dan berapa banyak mainan yang mereka miliki", "Dengan menyebutkan banyak baju mereka"),
                    "Dengan menyebutkan nama dan sifat-sifat positif mereka",
                    "Ketika kita menyebutkan identitas nonfisik teman di sekolah, kita dapat menggunakan cara yang baik dengan menyebutkan nama mereka dan sifat-sifat positif yang dimiliki oleh teman tersebut. Misalnya, kita bisa mengatakan bahwa teman kita Ramdan adalah orang yang ramah, atau Maria adalah orang yang sangat baik dan suka membantu. Itu adalah cara yang bagus untuk memperkenalkan teman kita kepada orang lain dan membuat mereka merasa dihargai."
                ),
                QuestionModel(
                    "Mana yang termasuk dalam identitas fisik seseorang?",
                    listOf("Agama dan suku", "Warna kulit, mata, dan rambut", "Hobi dan cita-cita", "Kelebihan dan kekurangan"),
                    "Warna kulit, mata, dan rambut",
                    "Identitas fisik seseorang mencakup hal-hal yang bisa dilihat atau dirasakan secara langsung, seperti warna kulit, mata, dan rambut. Ini adalah ciri-ciri yang membantu orang lain mengenali kita dan membuat kita berbeda dari orang lain. Misalnya, warna kulit kita bisa putih, coklat, atau hitam, mata kita bisa berwarna coklat, biru, atau hijau, dan rambut kita bisa lurus, keriting, atau bergelombang."
                ),
                QuestionModel(
                    "Pelaksanaan Pemilihan Umum (Pemilu) di Indonesia dilakukan setiap...",
                    listOf("4 tahun sekali", "5 tahun sekali", "6 tahun sekali", "7 tahun sekali"),
                    "5 tahun sekali",
                    "Pemilu Presiden dan Wakil Presiden dilaksanakan setiap 5 (lima) tahun sekali yang dilaksanakan di seluruh wilayah Negara Kesatuan Republik Indonesia sebagai satu kesatuan daerah pemilihan. Pemungutan suara dilaksanakan secara serentak pada hari libur atau hari yang diliburkan. Hari, tanggal, dan waktu pemungutan suara Pemilu Presiden dan Wakil Presiden ditetapkan dengan keputusan KPU. Pemilu Presiden dan Wakil Presiden dilaksanakan setelah pelaksanaan pemilihan umum anggota DPR, DPD, dan DPRD."
                ),
                QuestionModel(
                    "Harga diri suatu negara bergantung dari sikap....",
                    listOf("Warga negaranya", "Presidennya", "Petugas kebersihan", "Pemerintah"),
                    "Warga negaranya",
                    "Harga diri berkaitan dengan cara seseorang berperilaku. Jika seseorang memiliki harga diri yang tinggi, mereka cenderung berperilaku positif. Sebaliknya jika citra diri rendah, seseorang akan cenderung berperilaku negatif."
                ),
                QuestionModel(
                    "Bersatu dalam keberagaman sesuai dengan pengamalan sila ke…Pancasila.",
                    listOf("Satu", "Dua", "Tiga", "Empat"),
                    "Tiga",
                    "Pernyataan diatas sesuai dengan pengamalan Pancasila sila ke-3 yaitu Persatuan Indonesia."
                )
            )
        8  ->  listOf(
                QuestionModel(
                    "Tentukanlah mana yang merupakan cara melestarikan budaya daerah di Indonesia di bawah ini...",
                    listOf("Mengajarkan budaya daerah kepada orang lain", "Menyimpan kekayaan budaya daerah hanya untuk diri sendiri", "Membiarkan budaya daerah punah karena dianggap kuno", "Mengganti budaya daerah dengan budaya modern"),
                    "Mengajarkan budaya daerah kepada orang lain",
                    "Beberapa cara untuk melestarikan budaya daerah di Indonesia, antara lain: Mengajarkan budaya daerah kepada orang lain, baik di lingkungan rumah maupun sekolah. Hal ini akan berdampak positif bagi kelestarian budaya daerah. Menyimpan kekayaan budaya daerah hanya untuk diri sendiri bukanlah cara yang tepat untuk melestarikannya. Membiarkan budaya daerah punah karena dianggap kuno juga bukan solusi yang baik, karena akan menghilangkan identitas budaya daerah. Mengganti budaya daerah dengan budaya modern juga bukan cara yang tepat, karena akan menghilangkan kekayaan budaya daerah."
                ),
                QuestionModel(
                    "Seperti apa peran kalian sebagai generasi muda dalam mencegah kepunahan budaya daerah di Indonesia...",
                    listOf("Membiarkan budaya daerah punah karena dianggap kuno", "Mengganti budaya daerah dengan budaya modern", "Mempelajari dan mengembangkan budaya daerah", "Hanya menikmati budaya daerah tanpa melestarikannya"),
                    "Mempelajari dan mengembangkan budaya daerah",
                    "Peran yang dapat generasi muda ambil dalam mencegah kepunahan budaya daerah di Indonesia yaitu dengan mempelajari serta mengembangkan budaya yang ada di daerah agar budaya tersebut tidak sampai punah karena tidak ada yang mewasirinya."
                ),
                QuestionModel(
                    "Cara yang dapat dilakukan untuk mencegah agar budaya daerah di Indonesia tidak punah adalah...",
                    listOf("Membiarkan budaya daerah berkembang sendiri", "Mengganti budaya daerah dengan budaya modern", "Mengajarkan budaya daerah kepada generasi muda", "Hanya mempromosikan budaya daerah di tingkat nasional"),
                    "Mengajarkan budaya daerah kepada generasi muda",
                    "Cara mencegah agar budaya daerah di Indonesia tidak punah adalah dengan mengajarkan budaya daerah kepada generasi muda adalah cara yang tepat untuk mencegah kepunahan budaya daerah agar para generasi muda dapat mengajarkan kembali apa yang mereka ketahui tentang budaya daerah kepada generasi selanjutnya. Hal ini akan berdampak positif bagi kelestarian budaya daerah."
                ),
                QuestionModel(
                    "Pakaian adat merupakan salah satu bentuk keberagaman di Indonesia. Pernyataan yang tepat adalah ....",
                    listOf("Pakaian adat dipakai untuk perayaan nasional", "Pakaian adat antara satu daerah dengan daerah lain sama", "Pakaian adat menunjukkan kelebihan dari suatu daerah", "Pakaian adat menunjukkan ciri khas tertentu daerah"),
                    "Pakaian adat menunjukkan ciri khas tertentu daerah",
                    "Keberagaman di Indonesia salah satunya meliputi keberagaman pakaian adat. Pakaian adat menunjukkan ciri khas tertentu yang dimiliki daerah tersebut."
                ),
                QuestionModel(
                    "Bermusyawarah dalam menyelesaikan setiap permasalahan merupakan wujud dari pengamalan Pancasila sila ....",
                    listOf("Pertama", "Kedua", "Ketiga", "Keempat"),
                    "Keempat",
                    "Bermusyawarah dalam menyelesaikan setiap permasalahan merupakan wujud dari pengamalan sila keempat Pancasila, yaitu 'Kerakyatan yang Dipimpin oleh Hikmat Kebijaksanaan dalam Permusyawaratan/Perwakilan'. Sila ini menekankan pentingnya berunding dan mencapai keputusan bersama untuk kebaikan bersama."
                ),
                QuestionModel(
                    "Karakter para perumus Pancasila yang harus kita teladani, kecuali …. ",
                    listOf("Menegakkan kebenaran dan keadilan", "Berani berkorban", "Menghormati dan menghargai pendapat orang lain", "Mengutamakan kepentingan pribadi"),
                    "Mengutamakan kepentingan pribadi",
                    "Mengutamakan kepentingan pribadi bukan termasuk karakter perumus Pancasila, karena tidak mencerminkan nilai-nilai yang terkandung dalam Pancasila. Sebaliknya, karakter perumus Pancasila yang harus kita teladani diantaranya berani menegakkan kebenaran dan keadilan, rela berkorban dan menghormati dan menghargai pendapat orang lain."
                ),
                QuestionModel(
                    "Lambang Negara Indonesia adalah...",
                    listOf("Burung garuda", "Bhinneka Tunggal Ika", "UUD 1945", "Pancasila"),
                    "Burung garuda",
                    "Lambang negara Indonesia adalah Burung garuda, semboyan negara Indonesia adalah Bhineka Tunggal Ika dan dasar negara Indonesia adalah UUD 1945."
                ),
                QuestionModel(
                    "Tidak membedakan suku, agama, dan ras dalam berteman sesuai dengan Pancasila sila ke ...",
                    listOf("Pertama", "Kedua", "Ketiga", "Keempat"),
                    "Kedua",
                    "Sila ke-dua Pancasila berbunyi 'Kemanusiaan yang adil dan beradab'. Nilai yang terkandung dalam sila ke dua pancasila adalah saling menghormati dan menghargai anatar sesama manusia tanpa membedakan adat, agama, budaya dan suku."
                ),
                QuestionModel(
                    "Jarak rumah Sri ke sekolah sangat dekat, meskipun orang tua Sri memiliki kendaraan roda empat Sri tidak menggunakan fasilitas itu. Sri lebih suka jalan kaki bersama teman-temannya. Sikap Sri mencerminkan makna sila Pancasila, yaitu....",
                    listOf("Sombong", "Rendah diri", "Hidup sederhana", "Tinggi hati"),
                    "Hidup sederhana",
                    "Jarak rumah Sri ke sekolah sangat dekat, meskipun orang tua Sri memiliki kendaraan roda empat Sri tidak menggunakan fasilitas itu. Sri lebih suka jalan kaki bersama teman-temannya. Sikap Sri mencerminkan makna sila Pancasila, yaitu hidup sederhana."
                ),
                QuestionModel(
                    "Proses penunjukan pengurus organisasi dengan cara ditunjuk langsung oleh seluruh anggota organisasi disebut …. ",
                    listOf("Interpelasi", "Demokrasi", "Aklamasi", "Instruksi"),
                    "Aklamasi",
                    "Menurut Kamus Besar Bahasa Indonesia (KBBI) Aklamasi didefinisikan sebagai pernyataan setuju secara lisan dari seluruh peserta rapat terhadap suatu usul tanpa melalui pemungutan suara."
                )
            )
               10 -> listOf(
                QuestionModel(
                    "Pelaksanaan Pemilihan Umum (Pemilu) di Indonesia dilakukan setiap...",
                    listOf("4 tahun sekali", "5 tahun sekali", "6 tahun sekali", "7 tahun sekali"),
                    "5 tahun sekali",
                    "Pemilu Presiden dan Wakil Presiden dilaksanakan setiap 5 (lima) tahun sekali yang dilaksanakan di seluruh wilayah Negara Kesatuan Republik Indonesia sebagai satu kesatuan daerah pemilihan. Pemungutan suara dilaksanakan secara serentak pada hari libur atau hari yang diliburkan. Hari, tanggal, dan waktu pemungutan suara Pemilu Presiden dan Wakil Presiden ditetapkan dengan keputusan KPU. Pemilu Presiden dan Wakil Presiden dilaksanakan setelah pelaksanaan pemilihan umum anggota DPR, DPD, dan DPRD."
                ),
                QuestionModel(
                    "Di Indonesia, pemilu pertama diselenggarakan pada tahun...",
                    listOf("1955", "1971", "1977", "1982"),
                    "1955",
                    "Pemilihan Umum (Pemilu) 1955 merupakan Pemilu yang pertama dalam sejarah bangsa Indonesia yang digelar secara nasional. Pemilu 1955 dilakukan dua kali. Yang pertama, pada 29 September 1955 untuk memilih anggota-anggota DPR. Yang kedua, 15 Desember 1955 untuk memilih anggota-anggota Dewan Konstituante. Pemilu ini diikuti oleh lebih dari 30 partai politik dan lebih dari seratus daftar kumpulan dan calon perorangan."
                ),
                QuestionModel(
                    "Setiap orang berhak mengembangkan diri melalui pemenuhan kebutuhan dasarnya, berhak mendapat pendidikan dan memperoleh manfaat dari ilmu pengetahuan dan teknologi, seni dan budaya, demi meningkatkan kualitas hidupnya dan demi kesejahteraan umat manusia. Pernyataan ini merupakan isi dari UUD pasal berapa?",
                    listOf("28 C Ayat (1)", "28 E Ayat (1)", "28 C Ayat (2)", "29 C Ayat (1)"),
                    "28 C Ayat (1)",
                    "Pasal 28C ayat (1) UUD NRI Tahun 1945 menyatakan bahwa, “Setiap orang berhak mengembangkan diri melalui pemenuhan kebutuhan dasarnya, berhak mendapat pendidikan dan memperoleh manfaat dari ilmu pengetahuan dan teknologi, seni dan budaya, demi meningkatkan kualitas hidupnya dan demi kesejahteraan umat manusia.”"
                ),
                QuestionModel(
                    "Yang termasuk tugas Presiden sebagai kepala negara, yakni...",
                    listOf("menetapkan Peraturan Pemerintah", "mengangkat dan memberhentikan menteri-menteri", "membentuk dewan pertimbangan", "membuat perjanjian dengan negara lain"),
                    "membuat perjanjian dengan negara lain",
                    "Tugas dan wewenang presiden dibagi menjadi dua yakni tugas presiden sebagai kepala negara dan tugas presiden sebagai kepala pemerintahan. Tugas presiden sebagai kepala negara meliputi membuat perdamaian dan perjanjian dengan negara lain, serta menyatakan keadaan bahaya, mengangkat duta dan konsul, memberikan grasi dan rehabilitasi, dan lain-lain."
                ),
                QuestionModel(
                    "Berikut ini bukan tugas dan fungsi MPR, yakni...",
                    listOf("menetapkan UUD", "melantik Presiden dan Wakil Presiden", "memberhentikan Presiden/Wakil Presiden", "memeriksa keuangan negara"),
                    "memeriksa keuangan negara",
                    "MPR (Majelis Permusyawaratan Rakyat) mempunyai tugas mengubah dan menetapkan UUD, melantik presiden dan wakil presiden, memutuskan usul DPR untuk memberhentikan presiden atau wakil presiden, serta menetapkan peraturan tata tertib dan kode etik MPR. Pemeriksaan keuangan negara merupakan tugas BPK."
                ),
                QuestionModel(
                    "Berdasarkan UUD 1945, bentuk pemerintahan Indonesia adalah Republik dengan sistem kabinet presidensil. Sedangkan berdasarkan konstitusi RIS 1949 ialah ...",
                    listOf("Kesatuan berbentuk republik", "Republik dengan sistem kabinet parlementer", "Republik berbentuk federasi", "Kesatuan dengan sistem demokrasi terpimpin"),
                    "Republik dengan sistem kabinet parlementer",
                    "Selama berlakunya Kabinet RIS 1949 - 1950, Pemerintah Indonesia menggunakan sistem kabinet parlementer. Konstitusi RIS 1949 membagi Indonesia menjadi negara-negara bagian dengan sistem parlementer, sedangkan UUD 1945 tetap berlaku untuk negara bagian Republik Indonesia."
                ),
                QuestionModel(
                    "Kristin beragama Katolik sedang Mahmud beragama Islam. Ketika itu hari Minggu. Saat sedang menyelesaikan tugas kelompok, hari sudah menjelang sore. Kristin meminta izin melaksanakan ibadah di gereja. Sikap yang baik dilakukan Ahmad adalah...",
                    listOf("Melarang Kristin karena tugas belum selesai", "Meminta Kristin menunda ibadahnya pekan depan", "Mempersilahkan Kristin pergi beribadah ke gereja", "Bersama Ahmad mengerjakan pergi ke gereja"),
                    "Mempersilahkan Kristin pergi beribadah ke gereja",
                    "Pada sila pertama Pancasila yaitu Ketuhanan Yang Maha Esa mengandung nilai-nilai dimana seluruh warga Indonesia dapat memeluk agama masing-masing dan beribadah menurut agamanya. Oleh karena itu, kita seharusnya saling menghargai teman yang berbeda agama dan mempersilahkannya untuk beribadah sesuai keyakinannya."
                ),
                QuestionModel(
                    "Salah satu cara mewujudkan persatuan adalah menjaga kerukunan. Berikut ini kegiatan yang mencerminkan kerukunan di sekolah adalah...",
                    listOf("Tidak mengejek teman jika ada guru di dalam kelas", "Membentuk kelompok belajar khusus untuk anak yang pandai", "Saling menolong pada waktu piket membersihkan kelas", "Memberikan jawaban kepada teman saat ujian"),
                    "Saling menolong pada waktu piket membersihkan kelas",
                    "Kerukunan berarti sepakat dalam perbedaan-perbedaan yang ada dan menjadikan perbedaan itu sebagai titik tolak untuk membina kehidupan sosial yang saling pengertian serta menerima dengan ketulusan hati yang penuh keikhlasan."
                ),
                QuestionModel(
                    "Ketika sedang belajar kelompok ada dua teman yang berselisih, sikap Rizal sebagai ketua kelompok adalah...",
                    listOf("Condong pada salah satu pihak dan menyalahkan yang lain", "Diam saja, biarkan, karena nanti damai dengan sendirinya", "Mendamaikan supaya keutuhan kelompok terjaga", "Memberi sanksi pada teman yang salah"),
                    "Mendamaikan supaya keutuhan kelompok terjaga",
                    "Sebagai ketua kelompok, Rizal bertanggung jawab dalam menjaga keutuhan kelompok. Sikap yang baik adalah mendamaikan konflik agar kelompok tetap harmonis dan produktif."
                ),
                QuestionModel(
                    "Hak yang dimiliki oleh setiap warga negara Indonesia untuk memilih dan dipilih dalam pemilu disebut...",
                    listOf("hak asasi manusia", "hak politik", "hak ekonomi", "hak sosial"),
                    "hak politik",
                    "Hak politik adalah hak yang dimiliki setiap orang untuk meraih, merebut kekuasaan, kedudukan, dan kekayaan yang berguna bagi dirinya. Penyaluran hak politik tersebut diwujudkan melalui pemilihan umum (Pemilu)."
                )
            )



            else -> emptyList()
        }
    }
}
