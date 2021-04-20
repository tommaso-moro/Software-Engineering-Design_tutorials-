package ic.doc.camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {

  private static final byte[] IMAGE_DATA = new byte[8];
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  Sensor cameraSensor = context.mock(Sensor.class);
  MemoryCard cameraMemoryCard = context.mock(MemoryCard.class);

  Camera camera = new Camera(cameraSensor, cameraMemoryCard);

  @Test
  public void switchingTheCameraOnPowersUpTheSensor() {
    context.checking(new Expectations() {{
      exactly(1).of(cameraSensor).powerUp();
    }});
    camera.powerOn();
  }

  @Test
  public void switchingTheCameraOffPowersDownTheSensor() {
    context.checking(new Expectations() {{
      ignoring(cameraSensor).powerUp();
      exactly(1).of(cameraSensor).powerDown();
    }});

    camera.powerOn();
    camera.powerOff();
  }

  @Test
  public void pressingTheShutterWhenCameraIsOffDoesNothing() {

    context.checking(new Expectations() {{
      never(cameraSensor);
      never(cameraMemoryCard);

    }});

    camera.pressShutter();
  }

  @Test
  public void pressingTheShutterWhenCameraIsOnCopiesDataFromSensorToMemoryCard() {

    context.checking(new Expectations() {{
      ignoring(cameraSensor).powerUp();
      exactly(1).of(cameraSensor).readData(); will(returnValue(IMAGE_DATA));
      exactly(1).of(cameraMemoryCard).write(IMAGE_DATA);
    }});

    camera.powerOn();
    camera.pressShutter();
  }

  @Test
  public void cameraDoesNotPowerDownSensorUntilWritingIsComplete() {

    context.checking(new Expectations() {{
      ignoring(cameraSensor).powerUp();
      exactly(1).of(cameraSensor).readData(); will(returnValue(IMAGE_DATA));
      exactly(1).of(cameraMemoryCard).write(IMAGE_DATA);
    }});

    camera.powerOn();
    camera.pressShutter();

    context.checking(new Expectations() {{
      exactly(0).of(cameraSensor).powerDown();
    }});

    camera.powerOff();

    context.checking(new Expectations() {{
      exactly(1).of(cameraSensor).powerDown();
    }});

    camera.writeComplete();
    camera.powerOff();

  }

}
