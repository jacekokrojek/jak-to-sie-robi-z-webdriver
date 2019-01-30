# Przygotowanie środowiska

## Instalacja Javy
 UWAGA! Jeśli posiadasz już Javę na swoim komputerze ale w niższej wersji, to zaktualizuj ją do wersji 11 lub usuń całkowicie i zainstaluj ponownie według poniższej instrukcji!
 
 1. Wejdź na stronę https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
 2. Pobierz wesję dla Windows w formacie .exe
 3. Otwórz pobrany plik i zainstaluj Javę (wszystkie ustawienia podczas instalacji pozostaw domyślne)
 4. Ustaw zmienną środowiskową JAVA_HOME (instrukcja jak to zrobić dla poszczególnych wersji Windows znajduje się tutaj: https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
 
## Instalacja IntelliJ IDEA
 1. Wejdź na stronę https://www.jetbrains.com/idea/download/#section=windows
 2. Pobierz wersję Community (jest darmowa) dla Windows
 3. Otwórz poprany plik i zainstaluj aplikację (można zostawić wszystkie ustawienia domyślne, nie powinno to stanowić problemu)

# Wyszukiwanie elemntów z wykorzystaniem Selenium 

## Objekt By

* By.className - finds elements based on the value of the "class" attribute 
* By.cssSelector - finds elements based on the driver's underlying CSS Selector engine
* By.id - locates elements by the value of their "id" attribute
* By.linkText - finds a link element by the exact text it displays
* By.name - locates elements by the value of the "name" attribute
* By.partialLinkText - locates elements that contain the given link text
* By.tagName - locates elements by their tag name
* By.xpath - locates elements via XPath

```
<footer>
	<div class="container">
		<div class="row">
			<div class="span6">Copyright © 2013 Shapebootstrap | All Rights Reserved </br>
				<small>Aliquam tincidunt mauris eu risus.</small>
			<div>
		</div>
		<div class="span6">
			<div class="social pull-right" data-test="footer-links">
				<a href="#"><img src="img/social/googleplus.png" alt=""></a>
				<a href="#"><img src="img/social/dribbble.png" alt=""></a>
				<a href="#"><img src="img/social/twitter.png" alt=""></a>
				<a href="#"><img src="img/social/dribbble.png" alt=""></a>
				<a href="#"><img src="img/social/rss.png" alt=""></a>
			</div>
		</div>
	</div>
</footer>
```  

### Przykłady selektorów css
* footer
* footer > div
* footer small
* div.span6
* .social a:nth-of-type(4)
* div[data-test='footer-links']

### Przykłady selektorów xpath
* //footer
* //footer/div
* //footer/div/div/div/small
* (//div[@class="span6"])[1]
* //div[@class="social pull-right"]
* //div[contains(@class,"social")]
* //div[contains(@class,"social")]/a[1]
* //div[@data-test='footer-links']

Referencje: https://saucelabs.com/resources/articles/selenium-tips-css-selectors
