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
    private long audioCount;
    private long videoCount;
    
    public SleepComfort(){}
    
    public SleepComfort(float audioValue, float videoValue, long audioCount, long videoCount) {
        this.audioValue = audioValue;
        this.videoValue = videoValue;
        this.audioCount = audioCount;
        this.videoCount = videoCount;
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
    
    public long getAudioCount() {
        return audioCount;
    }

    public void setAudioCount(long audioCount) {
        this.audioCount = audioCount;
    }

    public long getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(long videoCount) {
        this.videoCount = videoCount;
    }
    
}
