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
* //div[@class="span6"]
* //div[contains(@class,"social")]
* //div[@data-test='footer-links']

Referencje: https://saucelabs.com/resources/articles/selenium-tips-css-selectors
