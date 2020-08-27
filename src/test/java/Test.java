import kaptainwutax.mcutils.nbt.NBTFormatter;
import kaptainwutax.mcutils.nbt.NBTStream;
import kaptainwutax.mcutils.nbt.tag.NBTTag;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        NBTTag nbt = NBTStream.read("plains_meeting_point_1.nbt");
        System.out.println(NBTFormatter.format(nbt));

        NBTStream.write(nbt, "plains_meeting_point_1_dump.nbt", false);
        NBTTag dump = NBTStream.read("plains_meeting_point_1_dump.nbt");
        System.out.println(NBTFormatter.format(dump));
    }

}
