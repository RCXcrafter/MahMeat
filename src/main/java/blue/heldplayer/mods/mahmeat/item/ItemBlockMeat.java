package blue.heldplayer.mods.mahmeat.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockMeat extends ItemBlock {

    public ItemBlockMeat(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (stack.getItemDamage()) {
            case 0:
                return this.block.getUnlocalizedName();
            case 1:
                return this.block.getUnlocalizedName() + ".cooked";
            default:
                return this.block.getUnlocalizedName() + ".unknown";
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name").trim();
    }

    @Override
    public int getMetadata(int damage) {
        return damage & 1;
    }
}
