package hu.poke.poketrade.controller.param;

public class PokeTradeParam {
    private Long firstOwnerId;
    private Long firstPokemonId;
    private Long otherOwnerId;
    private Long otherPokemonId;

    public PokeTradeParam(Long firstOwnerId, Long firstPokemonId, Long otherOwnerId, Long otherPokemonId) {
        this.firstOwnerId = firstOwnerId;
        this.firstPokemonId = firstPokemonId;
        this.otherOwnerId = otherOwnerId;
        this.otherPokemonId = otherPokemonId;
    }

    public Long getFirstOwnerId() {
        return firstOwnerId;
    }

    public void setFirstOwnerId(Long firstOwnerId) {
        this.firstOwnerId = firstOwnerId;
    }

    public Long getFirstPokemonId() {
        return firstPokemonId;
    }

    public void setFirstPokemonId(Long firstPokemonId) {
        this.firstPokemonId = firstPokemonId;
    }

    public Long getOtherOwnerId() {
        return otherOwnerId;
    }

    public void setOtherOwnerId(Long otherOwnerId) {
        this.otherOwnerId = otherOwnerId;
    }

    public Long getOtherPokemonId() {
        return otherPokemonId;
    }

    public void setOtherPokemonId(Long otherPokemonId) {
        this.otherPokemonId = otherPokemonId;
    }
}
