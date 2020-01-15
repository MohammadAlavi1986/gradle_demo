package me.smash;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleTest {

  private WebDriver webDriver;
  @Before
  public void setUp() throws MalformedURLException {
    webDriver = new RemoteWebDriver(new URL("http://blueo-selenium:4444/wd/hub"),
        DesiredCapabilities.chrome());
  }

  @After
  public void tearDown() {
    if (webDriver != null) {
      webDriver.quit();
    }
  }

  @Test
  public void test() throws InterruptedException {

    webDriver.get("http://jenkins-blueocean:8090/todo");

    Thread.sleep(3000);

    assertEquals("----", webDriver.getTitle());
    webDriver.close();
  }

}
