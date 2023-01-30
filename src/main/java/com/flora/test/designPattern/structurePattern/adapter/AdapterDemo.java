package com.flora.test.designPattern.structurePattern.adapter;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午4:08
 */
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("Vlc","yoyoyo.Vlc");
        audioPlayer.play("Mp4","yoyoyo.Mp4");
        audioPlayer.play("Mp3","yoyoyo.Mp3");
        audioPlayer.play("avi","yoyoyo.avi");
    }
}
//原媒体，只能播放Mp3
interface MediaPlayer{
    public void play(String type, String name);
}
//改进的媒体，扩展了两种
interface AdvancedMediaPlayer{
    public void playVlc(String name);
    public void playMp4(String name);
}
class VlcPlayer implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String name) {
        System.out.println("playing Vlc:" + name);
    }

    @Override
    public void playMp4(String name) {

    }
}
class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String name) {

    }

    @Override
    public void playMp4(String name) {
        System.out.println("playing Mp4:" + name);
    }
}
//创建适配器类 实现原MediaPlayer接口
class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type) {
        if(type.equalsIgnoreCase("Vlc")) advancedMediaPlayer = new VlcPlayer();
        if(type.equalsIgnoreCase("Mp4")) advancedMediaPlayer = new Mp4Player();
    }

    @Override
    public void play(String type, String name) {
        if(type.equalsIgnoreCase("Vlc")) advancedMediaPlayer.playVlc(name);
        if(type.equalsIgnoreCase("Mp4")) advancedMediaPlayer.playMp4(name);
    }
}
class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;
    @Override
    public void play(String type, String name) {
        if(type.equalsIgnoreCase("Vlc") || type.equalsIgnoreCase("Mp4")){
            mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type,name);
        }else if (type.equalsIgnoreCase("Mp3")){
            System.out.println("Playing Mp3");
        }else{
            System.out.println("This is not a support type");
        }
    }
}
