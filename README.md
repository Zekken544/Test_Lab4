# Лаборатори 4 — JUnit 5

**Оюутан:** М. Билгүүн-Эрдэнэ  
**Оюутны код:** B222270046

## Хэрэгслийн хувилбар

Windows PowerShell дээр ажиллуулсан командын гаралт:

```text
> java -version
openjdk version "17.0.21.0.2" 2026-10-22 LTS
OpenJDK Runtime Environment Microsoft-15779939 (build 17.0.21.0.2+1-LTS)
OpenJDK 64-Bit Server VM Microsoft-15779939 (build 17.0.21.0.2+1-LTS, mixed mode, sharing)

> mvn -version
Apache Maven 3.10.1 (3afd8084b5629f80b97750906a719879ed4cd283)
Maven home: C:\Users\satan\Downloads\apache-maven-3.10.1-bin\apache-maven-3.10.1
Java version: 17.0.21.0.2, vendor: Microsoft, runtime: C:\Program Files\Microsoft\jdk-17.0.21.21-hotspot
Default locale: en_US, platform encoding: Cp1252, time zone: Asia/Ulaanbaatar
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

## Ажиллуулах

Java 17+ болон Maven суулгасан орчинд репозиторийн үндсэн хавтсаас:

```powershell
mvn -B clean test
```

## Тестийн үр дүн

- Тестийн метод: **10** — 8 `@Test`, 2 `@ParameterizedTest`.
- Parameterized тестийн мөр: **15** — үсгэн дүнд 11, нийлбэр оноонд 4.
- [Үндсэн лог](results/mvn-test.txt): **23 тест, 0 failures, 0 errors, 0 skipped**, `BUILD SUCCESS`.
- Метод бүр AAA бүтэц, монгол `@DisplayName` тайлбартай.

## Мутаци

`score >= 90` нөхцөлийг түр `score > 90` болгосон.

[Мутацийн лог](results/mvn-test-mutant.txt)-т 23 тестээс 2 унасан, `BUILD FAILURE`, exit code `1`:

- `GradeCalculatorTest.letterGrade_exactly90_returnsA`
- `GradeCalculatorParameterizedTest.letterGrade_variousScores_returnsExpectedGrade` — 90 онооны мөр

Хоёул `expected: <A> but was: <B>` гэж унасан. Зөв кодыг сэргээсний дараа бүх 23 тест дахин тэнцсэн.

## Дүгнэлт

`GradeCalculator` нь оноог үсгэн дүнд хувиргаж, таван хэсгийн нийлбэрийг тооцдог.
Хэсэг бүрийн сөрөг болон дээд хязгаараас хэтэрсэн оролтыг `assertThrows` ашиглан шалгасан.
Ердийн утга болон 90, 89.99, 60, 59.99, 0, 100 гэсэн заагуудыг хамруулсан.
Parameterized тест нь олон оролтыг нэг логикоор шалгах боломж олгосон.
Хамгийн сонирхолтой нь яг 90 онооны тест харьцуулах операторын өөрчлөлтийг илрүүлсэн явдал байв.
Ердийн 95 онооны шалгалт энэ өөрчлөлтийг илрүүлэхгүй тул зааг утгын тест чухал.
AI-аас код, тест болон README-ийн тусламж авч, тестүүдийг ажиллуулан мутацийн үр дүнг шалгасан.