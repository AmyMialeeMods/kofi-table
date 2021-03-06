package amymialee.kofitable.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class KofiCupItem extends Item {
    public KofiCupItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            List<StatusEffect> list = Registry.STATUS_EFFECT.stream().filter(StatusEffect::isBeneficial).toList();
            user.addStatusEffect(new StatusEffectInstance(list.get(world.random.nextInt(list.size())), 40 * 20, 0, true, false));
            user.getItemCooldownManager().set(this, 60 * 20);
            world.playSoundFromEntity(null, user, SoundEvents.ENTITY_WITCH_DRINK, SoundCategory.PLAYERS, 1, 1);
        }
        return super.use(world, user, hand);
    }
}