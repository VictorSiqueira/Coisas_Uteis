https://code.google.com/archive/p/openssl-for-windows/downloads

baixar e colocar o conteudo openssl em uma pasta C:\OpenSSL

abrir o diretorio do jre/bin do seu java no prompt

no meu caso "C:\Program Files\Java\jre7\bin"

e depois executar o comando

keytool -exportcert -alias androiddebugkey -keystore %HOMEPATH%\.android\debug.keystore | "C:\OpenSSL\bin\openssl" sha1 -binary | "C:\OpenSSL\bin\openssl" base64

e5nmZJJ0DxuB0uaeT98rPpEG5Go=

https://www.youtube.com/watch?v=ATsINaI3WMQ
https://developers.facebook.com/quickstarts/1536479089991272/?platform=android