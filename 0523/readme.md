# 🕒 Alarm To-Do List App (Android)

할 일을 입력하고, 원하는 날짜와 시간에 맞춰 알림을 받을 수 있는 간단한 Android 알람 투두 앱입니다.  
`TimePicker + DatePicker + AlarmManager`를 활용한 알림 기능을 구현했습니다.

---

## ✨ 주요 기능

- 할 일(Task) 입력
- 날짜 선택 (DatePickerDialog)
- 시간 선택 (TimePicker)
- 알람 등록 (AlarmManager + BroadcastReceiver)
- 알림(Notification)을 통해 할 일 리마인드

---

## 📂 주요 구성 파일

| 파일명                | 설명                                                   |
|----------------------|--------------------------------------------------------|
| `MainActivity.java`   | 메인 화면. 할 일 입력, 날짜·시간 선택, 알람 예약 기능 |
| `AlarmReceiver.java`  | 알람 발생 시 실행되는 리시버. Notification 띄움       |
| `AndroidManifest.xml` | 권한 설정, 액티비티 & 리시버 등록                    |
| `activity_main.xml`   | UI 화면 구성 (입력창, 버튼, 타임피커 등 포함)        |

---

## ⚠️ 권한 설정

다음 권한이 `AndroidManifest.xml`에 선언되어야 합니다:

```xml
<uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

