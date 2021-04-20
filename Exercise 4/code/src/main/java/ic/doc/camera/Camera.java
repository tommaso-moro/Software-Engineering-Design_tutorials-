package ic.doc.camera;

public class Camera implements WriteListener {
  private Sensor cameraSensor;
  private MemoryCard cameraMemoryCard;
  private boolean cameraIsOn = false;
  private boolean writing = false;

  public Camera(Sensor cameraSensor, MemoryCard cameraMemoryCard) {
    this.cameraSensor = cameraSensor;
    this.cameraMemoryCard = cameraMemoryCard;
  }


  public void pressShutter() {
    if (cameraIsOn) {
      writing = true;
      byte[] data = cameraSensor.readData();
      cameraMemoryCard.write(data);
    }
  }

  public void powerOn() {
    cameraSensor.powerUp();
    cameraIsOn = true;
  }

  public void powerOff() {
    if (!writing) {
      cameraSensor.powerDown();
    }
    cameraIsOn = false;
  }

  @Override
  public void writeComplete() {
    writing = false;
  }
}

