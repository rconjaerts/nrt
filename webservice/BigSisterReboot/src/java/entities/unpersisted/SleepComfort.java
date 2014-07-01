/*
 * Group NRT
 * Hackiothon
 */
package entities.unpersisted;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niels
 */
@XmlRootElement
public class SleepComfort {
    
    private float audioValue;
    private float videoValue;
    
    public SleepComfort(){}
    
    public SleepComfort(float audioValue, float videoValue) {
        this.audioValue = audioValue;
        this.videoValue = videoValue;
    }
    
    public void setAudioValue(float audioValue) {
        this.audioValue = audioValue;
    }
    
    public float getAudioValue() {
        return this.audioValue;
    }
    
    public void setVideoValue(float videoValue) {
        this.videoValue = videoValue;
    }
    
    public float getVideoValue() {
        return this.videoValue;
    }
    
}
