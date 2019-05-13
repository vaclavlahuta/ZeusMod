package fit.seems.mc.zeusmod;

import org.bukkit.entity.Player;

public class SpeedPreset
{
	private Player player;

	private boolean isActive = false;

	private float
		walkSpeed,
		zeusWalkSpeed,
		flySpeed,
		zeusFlySpeed;


	public SpeedPreset(Player player)
	{
		this.player = player;
		reset();
	}

	public Player getPlayer()
	{
		return player;
	}

	public void reset()
	{
		walkSpeed = 0.2f;
		zeusWalkSpeed = 0.4f;
		flySpeed = 0.2f;
		zeusFlySpeed = 0.4f;

		player.setWalkSpeed(zeusWalkSpeed);
		player.setFlySpeed(zeusFlySpeed);
	}

	public void setZeusWalkSpeed(float speed)
	{
		zeusWalkSpeed = speed;
		if (isActive)
		{
			player.setWalkSpeed(speed);
		}
	}

	public void setZeusFlySpeed(float speed)
	{
		zeusFlySpeed = speed;
		if (isActive)
		{
			player.setFlySpeed(speed);
		}
	}

	public void activate()
	{
		player.setWalkSpeed(
			Math.max(player.getWalkSpeed(), zeusWalkSpeed));

		player.setFlySpeed(
			Math.max(player.getFlySpeed(), zeusFlySpeed));

		isActive = true;
	}

	public void deactivate()
	{
		player.setWalkSpeed(
			Math.min(player.getWalkSpeed(), walkSpeed));

		player.setFlySpeed(
			Math.min(player.getFlySpeed(), flySpeed));

		isActive = false;
	}
}