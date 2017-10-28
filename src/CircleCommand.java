import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CircleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            try{

                makeCircle(((Player) commandSender).getLocation(), Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));

            } catch (NumberFormatException e){

                e.printStackTrace();
                return false;

            }

        }
        return true;
    }

    private void makeCircle(Location loc, int radius, int deg){

        /*makeUpRight(loc, radius);
        makeDownRight(loc, radius);
        makeDownLeft(loc, radius);
        makeUpLeft(loc, radius);*/

        long start = System.nanoTime();

        World world = loc.getWorld();
        int y = loc.getBlockY();

        for (int i = 0; i < 360; i += deg){

            int x = Math.round((float) (loc.getBlockX() + radius * Math.cos(Math.toRadians(i))));
            int z = Math.round((float) (loc.getBlockZ() + radius * Math.sin(Math.toRadians(i))));

            Location l = new Location(world, x, y, z);
            l.getBlock().setType(Material.SMOOTH_BRICK);

        }

        System.out.println((System.nanoTime() - start) / 10E6 + "s");

    }

    private void makeUpRight(Location loc, int radius){

        World world = loc.getWorld();
        int y = loc.getBlockY();

        for (int x = 0; x < radius; ++x) {
            for (int z = radius; z > 0; --z) {

                if (Math.acos(x) == Math.asin(z)) {

                    Location l = new Location(world, loc.getBlockX() + x, y, loc.getBlockZ() + z);
                    l.getBlock().setType(Material.RED_NETHER_BRICK);

                }
            }
        }

    }

    private void makeDownRight(Location loc, int radius){

        World world = loc.getWorld();
        int y = loc.getBlockY();

        for (int x = radius; x > 0; --x) {
            for (int z = 0; z < radius; ++z) {

                Location l = new Location(world, loc.getBlockX() + x, y, loc.getBlockZ() + z);
                l.getBlock().setType(Material.RED_NETHER_BRICK);
            }
        }

    }

    private void makeDownLeft(Location loc, int radius){

        World world = loc.getWorld();
        int y = loc.getBlockY();

        for (int x = radius; x > 0; --x) {
            for (int z = 0; z < radius; ++z) {

                Location l = new Location(world, loc.getBlockX() + x, y, loc.getBlockZ() + z);
                l.getBlock().setType(Material.RED_NETHER_BRICK);
            }
        }

    }

    private void makeUpLeft(Location loc, int radius){

        World world = loc.getWorld();
        int y = loc.getBlockY();

        for (int x = 0; x < radius; ++x) {
            for (int z = radius; z > 0; --z) {

                Location l = new Location(world, loc.getBlockX() + x, y, loc.getBlockZ() + z);
                l.getBlock().setType(Material.RED_NETHER_BRICK);
            }
        }

    }
}
