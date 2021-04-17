import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.gen.PieceInfo;
import kaptainwutax.mcutils.nbt.NBTIO;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.mcutils.version.MCVersion;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        PieceInfo structure = new PieceInfo(MCVersion.v1_16_2).fromTag(NBTIO.read("plains_meeting_point_1.nbt"));
        structure.getPalette().replace(Block.COBBLESTONE, Block.STONE);
        structure.getBlockIDs().put(new BPos(0, 0, 0), structure.getPalette().indexOf(Block.STONE));
        NBTIO.write(structure.toTag(), "plains_meeting_point_1_modified.nbt", true);
    }

}
