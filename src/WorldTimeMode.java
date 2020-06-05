import java.lang.Thread;

public class WorldTimeMode implements Mode {
    TimeManager time_manager = new TimeManager();
    Segment segment = new Segment();
    Thread world_time_updater = new Thread();
    World[] worlds = new World[20];
    int world_index = 0;
    boolean locked = false;     // 초기에는 locked 되어있지 않으므로 false로 초기화

    void initWorldTimeMode() {

    }

    void nextWorldTime() {
        increaseWorldTimeIndex();

        // 변경된 값 세그먼트에 출력 SetSegmentUpper(“국가명”)
    }

    void prevWorldTime() {
        decreaseWorldTimeIndex();

        // 변경된 값 세그먼트에 출력 SetSegmentUpper(“국가명”)
    }

    void increaseWorldTimeIndex() {
        if(world_index > -1 && world_index < worlds.length) world_index++;
        else if(world_index == worlds.length) world_index = 0;
    }

    void decreaseWorldTimeIndex() {
        if(world_index > -1 && world_index < worlds.length) world_index--;
        else if(world_index == -1) world_index = worlds.length-1;
    }

    void holdCurrentWorldTime() {
        locked = true;
    }

    void releaseCurrentWorldTimeRock() {
        locked = false;
    }

    void syncWorldTime() {
        Time current_time = time_manager.getCurrentTime();   // 현재 시간
        Time current_world_time = new Time(current_time + worlds[world_index].weight);     // 현재시간 + 나라별 시간차 가중치
        //세그먼트 출력 어퍼/로워


    }

    @Override
    public void OnButtonA() {
        if(locked == false) prevWorldTime();
    }

    @Override
    public void OnButtonB() {
        if(locked == false) nextWorldTime();
    }

    @Override
    public void OnButtonC() {
        if(locked == true) releaseCurrentWorldTimeRock();   // 홀드 상태(true)면 잠금 해제(false)
        else holdCurrentWorldTime();    // 작금 해제 상태(false)면 홀드(true)
    }

    @Override
    public void OnEndOfThisMode() {

    }

    @Override
    public void OnInitThisMode() {

    }
}
