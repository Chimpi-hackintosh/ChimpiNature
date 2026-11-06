package br.com.chimpi.nature.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import java.util.Random;

public final class ChimpiNatureClient implements ClientModInitializer {
    private static final Random RANDOM = new Random();
    private static KeyBinding windKey;
    // 0 = desligado, 1 = leve, 2 = normal, 3 = forte
    private static int windMode = 2;
    private static long tick = 0;

    @Override
    public void onInitializeClient() {
        windKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.chimpinature.toggle_wind", InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V, "category.chimpinature"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            while (windKey.wasPressed()) {
                windMode = (windMode + 1) % 4;
                client.player.sendMessage(Text.translatable(
                        "message.chimpinature.wind", Text.translatable("mode.chimpinature." + windMode)), true);
            }
            if (!client.isPaused()) {
                tick++;
                renderWind(client);
            }
        });
    }

    private static void renderWind(MinecraftClient client) {
        if (windMode == 0) return;
        int cadence = windMode == 1 ? 14 : windMode == 2 ? 9 : 5;
        if (tick % cadence != 0) return;

        int count = windMode == 3 ? 3 : 2;
        for (int i = 0; i < count; i++) {
            double x = client.player.getX() + (RANDOM.nextDouble() - 0.5) * 18;
            double y = client.player.getY() + 0.3 + RANDOM.nextDouble() * 4;
            double z = client.player.getZ() + (RANDOM.nextDouble() - 0.5) * 18;
            BlockPos pos = BlockPos.ofFloored(x, y, z);
            if (!client.world.isSkyVisible(pos) || !client.world.isAir(pos)) continue;

            double speed = (windMode == 3 ? 0.10 : windMode == 2 ? 0.06 : 0.03)
                    * (client.world.isRaining() ? 1.4 : 1.0);
            double vx = speed * (0.75 + RANDOM.nextDouble() * 0.5);
            double vz = speed * 0.35;
            if (RANDOM.nextInt(5) == 0) {
                client.world.addParticle(ParticleTypes.CHERRY_LEAVES, x, y, z, vx, 0.0, vz);
            } else {
                client.world.addParticle(new DustParticleEffect(
                        new Vector3f(0.46f, 0.68f, 0.37f), 0.45f),
                        x, y, z, vx, 0.005, vz);
            }
        }
    }
}
