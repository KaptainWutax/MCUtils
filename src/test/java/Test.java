import kaptainwutax.mcutils.nbt.NBTStream;
import kaptainwutax.mcutils.nbt.tag.NBTCompound;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        NBTCompound nbt = NBTStream.read("plains_meeting_point_1.nbt").run(System.out::println);

        NBTStream.write(nbt, "plains_meeting_point_1_dump.nbt", false);
        NBTStream.read("plains_meeting_point_1_dump.nbt").run(System.out::println);

        NBTStream.write(nbt, "plains_meeting_point_1_dump.nbt", true);
        NBTStream.read("plains_meeting_point_1_dump.nbt").run(System.out::println);
    }


}
