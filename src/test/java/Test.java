import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.block.Blocks;
import kaptainwutax.mcutils.gen.PieceInfo;
import kaptainwutax.mcutils.nbt.NBTIO;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.mcutils.version.MCVersion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws IOException {
        URL url= Test.class.getResource("plains_meeting_point_1.nbt");
        assert url != null;
        File file=new File(url.getFile());
        PieceInfo structure = new PieceInfo(MCVersion.v1_16_2).fromTag(NBTIO.read(file));
        structure.getPalette().replace(Blocks.COBBLESTONE, Blocks.STONE);
        structure.getBlockIDs().put(new BPos(0, 0, 0), structure.getPalette().indexOf(Blocks.STONE));
        File got = File.createTempFile("plains_meeting_point_1_modified", ".nbt");
        String outputPath = got.getAbsolutePath();
        System.out.println("Wrote file to "+outputPath);
        NBTIO.write(structure.toTag(), outputPath, true);
    }

}
