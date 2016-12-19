package com.nyrds.pixeldungeon.mobs.icecaves;

import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.blobs.ToxicGas;
import com.watabou.pixeldungeon.actors.buffs.Amok;
import com.watabou.pixeldungeon.actors.buffs.Blindness;
import com.watabou.pixeldungeon.actors.buffs.Paralysis;
import com.watabou.pixeldungeon.actors.buffs.Sleep;
import com.watabou.pixeldungeon.actors.buffs.Terror;
import com.watabou.pixeldungeon.actors.mobs.Mob;
import com.watabou.pixeldungeon.items.food.FrozenCarpaccio;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.sprites.DM300Sprite;
import com.watabou.utils.Random;

public class IceGuardianCore extends Mob {

	public IceGuardianCore() {
		spriteClass = DM300Sprite.class;
		
		hp(ht(70));
		EXP = 5;
		defenseSkill = 10;
		
		loot = new FrozenCarpaccio();
		lootChance = 0.2f;

		IMMUNITIES.add( Paralysis.class );
		IMMUNITIES.add( ToxicGas.class );
		IMMUNITIES.add( Terror.class );
		IMMUNITIES.add( Death.class );
		IMMUNITIES.add( Amok.class );
		IMMUNITIES.add( Blindness.class );
		IMMUNITIES.add( Sleep.class );
	}
	
	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 13, 18 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 21;
	}
	
	@Override
	public int dr() {
		return 11;
	}


	@Override
	public void die(Object cause) {
		super.die(cause);

		ressurrect();
		ressurrect();
	}

}