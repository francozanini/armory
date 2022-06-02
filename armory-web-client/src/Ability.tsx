export class Ability {
    public static STR = new Ability("Strength", 10);
    public static DEX = new Ability("Dexterity", 10);
    public static CON = new Ability("Constitution", 10);
    public static INT = new Ability("Intelligence", 10);
    public static WIS = new Ability("Wisdom", 10);
    public static CHA = new Ability("Charisma", 10);

    private constructor(public readonly name: string, private _score: number) {
        if (_score > 20 || _score < 0) throw Error("Ability score out of bounds");
    }

    public get score(): number {
        return this._score;
    }

    public modifier(): number {
        if (this._score < 2) return -5;
        if (this._score < 4) return -4;
        if (this._score < 6) return -3;
        if (this._score < 8) return -2;
        if (this._score < 10) return -1;
        if (this._score < 12) return 0;
        if (this._score < 14) return 1;
        if (this._score < 16) return 2;
        if (this._score < 18) return 3;
        if (this._score < 20) return 4;
        else return 5;
    }

    increaseScore(): number {
        if (this._score < 20) {
            this._score += 1;
        }
        return this._score;
    }

    decreaseScore(): number {
        if (this._score > 0) {
            this._score -= 1;
        }
        return this._score;
    }
}