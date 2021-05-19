package ar.edu.unju.fi.tp4.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "clientes")
public class Cliente {
	@Column(name = "cli_tipdoc")
	private String tipoDocumento ;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nroDocumento;
	@Column(name = "cli_nombAp", nullable=false)
	private String nombreApellido;
	@Column(name = "cli_email")
	private String email;
	@Column(name = "cli_pass")
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cli_fechaNac")
	private LocalDate fechaNacimiento;
	@Column(name = "cli_codArea")
	private Long codigoAreaTelefono;
	@Column(name = "cli_nroTel")
	private Long nroTelefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cli_fechaUltComp")
	private LocalDate fechaUltimaCompra; 
	
	public Cliente() {
	}

	public Cliente(String tipoDocumento, Long nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, Long codigoAreaTelefono, Long nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	 

	public Long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Long getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(Long codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public Long getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(Long nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	public int getEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		periodo.getYears();
		int edad = periodo.getYears();
		return edad;
	}
	
	public String getTiempoHastaCumple() {
		String texto = "";
		int anio = 0 ;
		LocalDate hoy = LocalDate.now();
		if (hoy.getMonthValue() < fechaNacimiento.getMonthValue()) {
			anio = hoy.getYear();
		}else {
			anio = hoy.getYear() +1;
		}
		LocalDate fechaProxCumple = LocalDate.of( anio, fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaProxCumple);
		
		texto = texto + periodo.getYears()+"A "+periodo.getMonths()+"M "+periodo.getDays()+"D ";
		
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime fechaHoraProxCumple = LocalDateTime.of(anio,fechaNacimiento.getMonth(),fechaNacimiento.getDayOfMonth(),0,0,0);
		
		Duration duracion = Duration.between(ahora,fechaHoraProxCumple);
		texto = texto + duracion.toHoursPart() + "H "+duracion.toMinutesPart()+"M "+duracion.toSecondsPart()+"S ";
		
		return texto;
	}
		public String getTTransDesdeFechaN() {
			int tiempoTrans = 0;
			
			LocalDate hoy = LocalDate.now();
			//Period periodo = Period.between(fechaNacimiento, hoy);
			
			tiempoTrans = (int) ChronoUnit.DAYS.between(fechaNacimiento, hoy);
			
			return tiempoTrans+"D";
		}
		
		public String getTTransDesdeUltCompra () {
			String tiempoTrans = "";
			
			LocalDate hoy = LocalDate.now();
			Period periodo = Period.between(fechaUltimaCompra, hoy);
			int anio = periodo.getYears();
			int mes = periodo.getMonths();
			int dia = periodo.getDays();
			
			tiempoTrans = anio+"A "+mes+"M "+dia+"D ";
			
			return tiempoTrans;
		}
	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono=" + nroTelefono
				+ ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}

	
}
