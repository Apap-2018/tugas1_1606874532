package com.apap.tugas1.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pegawai")
public class PegawaiModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "tempat_lahir", nullable = false)
    private String tempatLahir;

    @NotNull
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;

    @NotNull
    @Size(max = 255)
    @Column(name = "tahun_masuk", nullable = false)
    private String tahunMasuk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instansi", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private InstansiModel instansi;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "jabatan_pegawai",
            joinColumns = { @JoinColumn(name = "id_pegawai") },
            inverseJoinColumns = { @JoinColumn(name = "id_jabatan") })
    private List<JabatanModel> jabatanList;

	public double getGaji() {
		double gajiUtama = 0;
		double tunjangan = this.instansi.getProvinsi().getPresentaseTunjangan();
		if (jabatanList.size()>1) {
			JabatanModel max = Collections.max(jabatanList, pegawaiComparator);
			gajiUtama = max.getGajiPokok() + ((tunjangan / 100) * max.getGajiPokok());
		}
		else {
			gajiUtama = jabatanList.get(0).getGajiPokok() + (tunjangan * jabatanList.get(0).getGajiPokok());
		}
		return gajiUtama;
		
		
	}
	
	private static Comparator<JabatanModel> pegawaiComparator = new Comparator<JabatanModel>() {

		@Override
		
		public int compare(JabatanModel a, JabatanModel b) {
			if (a.getGajiPokok()<b.getGajiPokok()) {
				return -1;
			}
			else if (a.getGajiPokok()>b.getGajiPokok()) {
				return 1;
			}
			return 0;
		}
	};
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getTahunMasuk() {
		return tahunMasuk;
	}

	public void setTahunMasuk(String tahunMasuk) {
		this.tahunMasuk = tahunMasuk;
	}

	public InstansiModel getInstansi() {
		return instansi;
	}

	public void setInstansi(InstansiModel instansi) {
		this.instansi = instansi;
	}

	public List<JabatanModel> getJabatanList() {
		return jabatanList;
	}

	public void setJabatanList(List<JabatanModel> jabatanList) {
		this.jabatanList = jabatanList;
	}

	
/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(max = 20)
	private Long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name ="nip", nullable = false, unique = true)
	private String nip;
	
	@NotNull
	@Size(max = 255)
	@Column(name ="nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 255)
	@Column(name ="tempat_lahir", nullable = false)
	private String tempat_lahir;
	
	@NotNull
	@Column(name ="tanggal_lahir", nullable = false)
	private Date tanggal_lahir;
	
	@NotNull
	@Size(max = 255)
	@Column(name ="tahun_masuk", nullable = false)
	private String tahun_masuk;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instansi_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private InstansiModel instansi;
	//blm buat setter getter listjabatan
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name ="jabatanPerPegawai", joinColumns = {@JoinColumn(name="jabatan_id")})
	private List<JabatanModel> listJabatan;
*/	

	
}
