package ec.tws2.tcs.contfiables.model;

public class UserLogin {

    private String companyAbbreviation;
    private String user;
    private String token;
    private String sucursal;
    private String idempresa;
    private String nombreEmpresa;
    private String name;
    private String email;
    private boolean menu1=false;
    private boolean menu2=false;
    private boolean menu3=false;
    private boolean menu4=false;
    private boolean menu5=false;
    private boolean menu6=false;
    private boolean menu7=false;
    private boolean menu8=false;
    private boolean menu9=false;
    private boolean menu10=false;
    private boolean userLiquidador=false;
    private String caja;

    public String getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCompanyAbbreviation() {
        return companyAbbreviation;
    }

    public void setCompanyAbbreviation(String companyAbbreviation) {
        this.companyAbbreviation = companyAbbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }        

    public boolean isMenu1() {
        return menu1;
    }

    public void setMenu1(boolean menu1) {
        this.menu1 = menu1;
    }

    public boolean isMenu2() {
        return menu2;
    }

    public void setMenu2(boolean menu2) {
        this.menu2 = menu2;
    }

    public boolean isMenu3() {
        return menu3;
    }

    public void setMenu3(boolean menu3) {
        this.menu3 = menu3;
    }

    public boolean isMenu4() {
        return menu4;
    }

    public void setMenu4(boolean menu4) {
        this.menu4 = menu4;
    }

    public boolean isMenu5() {
        return menu5;
    }

    public void setMenu5(boolean menu5) {
        this.menu5 = menu5;
    }

    public boolean isMenu6() {
        return menu6;
    }

    public boolean isMenu7() {
        return menu7;
    }

    public void setMenu7(boolean menu7) {
        this.menu7 = menu7;
    }

    public boolean isMenu8() {
        return menu8;
    }

    public void setMenu8(boolean menu8) {
        this.menu8 = menu8;
    }

    public boolean isMenu9() {
        return menu9;
    }

    public void setMenu9(boolean menu9) {
        this.menu9 = menu9;
    }

    public boolean isMenu10() {
        return menu10;
    }

    public void setMenu10(boolean menu10) {
        this.menu10 = menu10;
    }        

    public void setMenu6(boolean menu6) {
        this.menu6 = menu6;
    }

    public boolean isUserLiquidador() {
        return userLiquidador;
    }

    public void setUserLiquidador(boolean userLiquidador) {
        this.userLiquidador = userLiquidador;
    }      

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }
    
    
    
}
