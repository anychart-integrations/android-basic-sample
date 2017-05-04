[<img src="https://cdn.anychart.com/images/logo-transparent-segoe.png?2" width="234px" alt="AnyChart - Robust JavaScript/HTML5 Chart library for any project">](https://anychart.com)

# android-basic-sample

Демо-приложение, демонстрирующее использование графиков от компании Anychart в приложении на базе Android.

# Запуск
Демо приложение запускается на устройствах Android 4 и выше.

## Использование AnyChart в вашем приложении
JavaScript файл может быть загружен из сети, но это требует наличие подключения.
JavaScript может быть загружен из памяти телефона. Для этого нужно поместить в вашем приложении скрипт в директорию assets.

Для использования графиков можно использовать WebView, в которое загружается HTML страница. См. файл assets/base.html.
Для загрузки скрипта из памяти телефона в HTML нужно добавить строку:
    <script src="file:///android_asset/anychart-bundle.min.js"></script>

Или для загрузки из сети:
    <script src="https://cdn.anychart.com/js/7.13.0/anychart-bundle.min.js"></script>

Остальная работа сводится к генерированию JS кода, который конфигурирует график. Демо-приложение содержит простую обертку (см package android.anychart.com.anychart), и пример использования (MyActivity.class).
Возможно, мы когда нибудь сделаем полноценную обертку, и вы сможете использовать графики Anychart, применяя минимум усилий.
