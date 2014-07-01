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
    private float sleepQualityValue;
    private int comfortScore;
    
    public SleepComfort(){}
    
    public SleepComfort(float audioValue, float videoValue, long audioCount, long videoCount, float sleepQualityValue, int comfortScore) {
        this.audioValue = audioValue;
        this.videoValue = videoValue;
        this.audioCount = audioCount;
        this.videoCount = videoCount;
        this.sleepQualityValue = sleepQualityValue;
        this.comfortScore = comfortScore;
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
    
    public float getSleepQualityValue() {
        return sleepQualityValue;
    }

    public void setSleepQualityValue(float sleepQualityValue) {
        this.sleepQualityValue = sleepQualityValue;
    }

    public int getComfortScore() {
        return comfortScore;
    }

    public void setComfortScore(int comfortScore) {
        this.comfortScore = comfortScore;
    }
    
}
